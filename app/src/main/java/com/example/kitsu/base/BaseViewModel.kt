package com.example.kitsu.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kitsu.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseViewModel() : ViewModel() {

    protected fun <T> Flow<Resource<T>>.collectRequest(liveData: MutableLiveData<Resource<T>>) {
        viewModelScope.launch {
            collect {
                liveData.postValue(it)
            }
        }
    }
}