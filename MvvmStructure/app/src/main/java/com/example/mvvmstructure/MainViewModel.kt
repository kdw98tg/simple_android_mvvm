package com.example.mvvmstructure

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel()
{
    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int>
        get() = _count

    fun addCount()
    {
        _count.value = (_count.value ?: 0) + 1
    }

    fun subCount()
    {
        val currentNumber = count.value ?: 0
        if (currentNumber > 0)
        {
            _count.value = currentNumber - 1
        }
    }


}