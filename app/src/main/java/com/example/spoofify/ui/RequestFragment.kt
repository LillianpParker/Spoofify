package com.example.spoofify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spoofify.R
import com.google.firebase.auth.FirebaseAuth


class RequestFragment : Fragment() {
    private lateinit var requestViewModel: RequestViewModel

    private lateinit var requestBtn: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        requestViewModel =
            ViewModelProvider(this).get(RequestViewModel::class.java)
        val root = inflater.inflate(R.layout.menu_request_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.request_statement)
        val editText : EditText = root.findViewById(R.id.request_text)
        requestViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it

        })
        requestBtn = root.findViewById(R.id.request_btn)

        requestBtn.setOnClickListener{
            Toast.makeText(activity, "Thanks! We've got your request!", Toast.LENGTH_LONG).show()
            editText.text.clear()
        }

        return root
    }
}