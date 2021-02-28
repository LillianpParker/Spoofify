package com.example.spoofify.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.spoofify.R



class SearchFragment : Fragment() {
    private lateinit var searchViewModel: SearchViewModel

    private lateinit var sendBtn: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
                ViewModelProvider(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.menu_search_fragment, container, false)
        val editText : EditText = root.findViewById(R.id.searchText)

        sendBtn = root.findViewById(R.id.send_btn)

        sendBtn.setOnClickListener {
            Toast.makeText(activity, "Searching...", Toast.LENGTH_SHORT).show()
                editText.text.clear()
    }
        return root
    }
}
