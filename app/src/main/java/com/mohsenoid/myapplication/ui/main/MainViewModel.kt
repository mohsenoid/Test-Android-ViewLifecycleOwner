package com.mohsenoid.myapplication.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val a: MutableLiveData<Boolean> = MutableLiveData(false)

    val b: MutableLiveData<Boolean> = MutableLiveData(false)

    interface Callback {
        fun onNextClick()
    }
}