package com.example.championsleagueuefa.presentation.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.CookieManager
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.championsleagueuefa.databinding.ActivityWebViewBinding
import com.example.championsleagueuefa.utils.CustomWebClient
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class WebViewActivity : AppCompatActivity() {

    private val INPUT_FILE_REQUEST_CODE = 1
    private val FILECHOOSER_RESULTCODE = 1
    private val TAG = MainActivity::class.java.simpleName
    private var mUploadMessage: ValueCallback<Uri>? = null
    private var mCapturedImageURI: Uri? = null
    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
    private var mCameraPhotoPath: String? = null

    private var _binding: ActivityWebViewBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<WebViewViewModel>()

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        webView = binding.webView
        progressBar = binding.progressBar
        swipeRefreshLayout = binding.swipeRefreshLayout

        webView.webViewClient = CustomWebClient(this)
        webView.webChromeClient = ChromeClient()
        webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        viewModel.setSettings(webView.settings)

        viewModel.res.observe(this) {
            if (it.response == "no") {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                progressBar.visibility = View.GONE
                webView.loadUrl(
                    it.response
                )
            }
            Log.d("CHECH_ACT", it.response)
        }

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            Handler(Looper.getMainLooper()).postDelayed({
                swipeRefreshLayout.isRefreshing = false
                webView.loadUrl(webView.url.toString())
            }, 900)
        }

        webView.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK &&
                event.action == MotionEvent.ACTION_UP &&
                webView.canGoBack()
            ) {
                webView.goBack()
                return@OnKeyListener true
            }
            false
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode !== INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
                super.onActivityResult(requestCode, resultCode, data)
                return
            }
            var results: Array<Uri>? = null
            // Check that the response is a good one
            if (resultCode == AppCompatActivity.RESULT_OK) {
                if (android.R.attr.data == null) {
                    // If there is not data, then we may have taken a photo
                    if (mCameraPhotoPath != null) {
                        results = arrayOf(Uri.parse(mCameraPhotoPath))
                    }
                } else {
                    val dataString: String? = data?.getDataString()
                    if (dataString != null) {
                        results = arrayOf(Uri.parse(dataString))
                    }
                }
            }
            mFilePathCallback?.onReceiveValue(results)
            mFilePathCallback = null
        } else if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
            if (requestCode != FILECHOOSER_RESULTCODE || mUploadMessage == null) {
                super.onActivityResult(requestCode, resultCode, data)
                return
            }
            if (requestCode == FILECHOOSER_RESULTCODE) {
                if (null == mUploadMessage) {
                    return
                }
                var result: Uri? = null
                try {
                    if (resultCode != AppCompatActivity.RESULT_OK) {
                        result = null
                    } else {
                        // retrieve from the private variable if the intent is null
                        result = data?.let { mCapturedImageURI ?: it.data }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "ACTIVITY_MAIN", e)
                }
                mUploadMessage!!.onReceiveValue(result)
                mUploadMessage = null
            }
        }
        return
    }

    inner class ChromeClient() : WebChromeClient() {

        private var mCustomView: View? = null
        private var mCustomViewCallback: CustomViewCallback? = null
        private var mOriginalOrientation = 0
        private var mOriginalSystemUiVisibility = 0

        override fun getDefaultVideoPoster(): Bitmap? {
            return if (mCustomView == null) {
                null
            } else BitmapFactory.decodeResource(applicationContext.resources, 2130837573)
        }

        override fun onHideCustomView() {
            (window.decorView as FrameLayout).removeView(mCustomView)
            mCustomView = null
            window.decorView.systemUiVisibility = mOriginalSystemUiVisibility
            requestedOrientation = mOriginalOrientation
            mCustomViewCallback!!.onCustomViewHidden()
            mCustomViewCallback = null
        }

        override fun onShowCustomView(
            paramView: View?,
            paramCustomViewCallback: CustomViewCallback?
        ) {
            if (mCustomView != null) {
                onHideCustomView()
                return
            }
            mCustomView = paramView
            mOriginalSystemUiVisibility = window.decorView.systemUiVisibility
            mOriginalOrientation = requestedOrientation!!
            mCustomViewCallback = paramCustomViewCallback
            (window.decorView as FrameLayout).addView(
                mCustomView,
                FrameLayout.LayoutParams(-1, -1)
            )
            window.decorView.systemUiVisibility = 3846 or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }

        @SuppressLint("SimpleDateFormat")
        @Throws(IOException::class)
        private fun createImageFile(): File? {
            // Create an image file name
            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileName = "JPEG_" + timeStamp + "_"
            val storageDir: File = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",  /* suffix */
                storageDir /* directory */
            )
        }

        //android 5.0
        override fun onShowFileChooser(
            view: WebView,
            filePath: ValueCallback<Array<Uri>>,
            fileChooser: FileChooserParams
        ): Boolean {
            mFilePathCallback?.let { it.onReceiveValue(null) }
            mFilePathCallback = filePath
            var takePicIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePicIntent?.resolveActivity(packageManager) != null) {
                var photoFile: File? = null
                try {
                    photoFile = createImageFile()
                    takePicIntent.putExtra("PhotoFile", mCameraPhotoPath)
                } catch (e: IOException) {
                    Log.e(TAG, "CANNOT TO CREATE AN IMAGE FILE", e)
                }
                if (photoFile != null) {
                    mCameraPhotoPath = "file:" + photoFile.absolutePath
                    takePicIntent.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile)
                    )
                } else {
                    takePicIntent = null
                }
            }
            val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
            contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
            contentSelectionIntent.setType("image/*")
            var intentArray: Array<Intent>? = null
            if (takePicIntent != null) {
                intentArray = arrayOf(takePicIntent)
            } else {
                intentArray = arrayOf()
            }
            val chooserIntent = Intent(Intent.ACTION_CHOOSER)
            chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
            chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
            startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE)
            return true
        }

    }

}