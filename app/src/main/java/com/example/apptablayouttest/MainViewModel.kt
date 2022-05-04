package com.example.apptablayouttest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val star = MutableLiveData<StarModel>()
}