package com.example.championsleagueuefa.presentation.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.championsleagueuefa.R
import com.example.championsleagueuefa.databinding.ActivityMainBinding
import com.example.championsleagueuefa.presentation.ui.matches.MatchesViewModel
import com.squareup.picasso.Picasso
import com.squareup.picasso.Picasso.LoadedFrom
import com.squareup.picasso.Target
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        loadBackground()
    }

    private fun loadBackground() {
        try {
            Picasso.get().load(IMAGE_URL).into(object : Target {
                override fun onBitmapLoaded(bitmap: Bitmap?, from: LoadedFrom?) {
                    binding.mainActivity.background = BitmapDrawable(resources, bitmap)
                }

                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    Log.d("ERROR", "download background image is failed -> ${e?.message}")
                }

                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

                }

            })
        } catch (e: Exception) {
            Log.e("ERROR", e.message, e)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val IMAGE_URL = "http://95.217.132.144/russian_sport/background_image.jpg"
    }

}