package com.example.spoofify.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spoofify.LoginActivity
import com.example.spoofify.R
import com.example.spoofify.UpdatePassword
import com.google.firebase.auth.FirebaseAuth


class SettingsFragment : Fragment() {
    private lateinit var settingsViewModel: SettingsViewModel
    private lateinit var auth: FirebaseAuth

    private lateinit var logoutBtn: Button
    private lateinit var updatePass: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
            ViewModelProvider(this).get(SettingsViewModel::class.java)
        val root = inflater.inflate(R.layout.menu_settings_fragment, container, false)

        logoutBtn = root.findViewById(R.id.logout_btn)
        updatePass = root.findViewById(R.id.update_pass_btn)

        logoutBtn.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
        }

        updatePass.setOnClickListener{
            val intent = Intent(activity, UpdatePassword::class.java)
            startActivity(intent)
        }
        return root
    }
}