package com.example.championsleagueuefa.presentation.ui.more

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.championsleagueuefa.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}