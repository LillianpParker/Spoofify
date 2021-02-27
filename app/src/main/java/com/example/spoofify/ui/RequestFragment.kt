package com.example.spoofify.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spoofify.R


class RequestFragment : Fragment() {
    private lateinit var requestViewModel: RequestViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        requestViewModel =
            ViewModelProvider(this).get(RequestViewModel::class.java)
        val root = inflater.inflate(R.layout.menu_request_fragment, container, false)
        val textView: TextView = root.findViewById(R.id.request_statement)
        requestViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}