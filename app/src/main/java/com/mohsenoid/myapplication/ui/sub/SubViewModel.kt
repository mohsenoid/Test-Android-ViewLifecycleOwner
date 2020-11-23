package com.mohsenoid.myapplication.ui.sub

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SubViewModel : ViewModel() {

    val c: MutableLiveData<Boolean> = MutableLiveData(false)

    val d: MutableLiveData<Boolean> = MutableLiveData(false)
}