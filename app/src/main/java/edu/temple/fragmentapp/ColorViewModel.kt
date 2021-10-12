package edu.temple.fragmentapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorViewModel : ViewModel(){
    private var color = MutableLiveData<String>()

    fun getColor () : LiveData<String> {
        return color
    }

    fun setColor (_color: String) {
        color.value = _color
    }

}