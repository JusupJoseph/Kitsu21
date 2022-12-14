package com.example.kitsu.base

import androidx.lifecycle.liveData
import com.example.kitsu.common.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doRequest(result: suspend () -> T) = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(result()))
        } catch (ioException: IOException) {
            emit(ioException.localizedMessage?.let { Resource.Error(it, null) })
        }
    }
}