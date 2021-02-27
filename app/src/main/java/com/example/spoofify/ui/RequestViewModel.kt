package com.example.spoofify.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RequestViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Request Fragment"
    }
    val text: LiveData<String> = _text
}