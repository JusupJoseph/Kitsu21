package com.example.kitsu.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kitsu.base.BaseRepository
import com.example.kitsu.data.pagingsources.AnimePagingSources
import com.example.kitsu.data.pagingsources.MangaPagingSources
import com.example.kitsu.data.remote.apiservices.anime.AnimeApiService
import com.example.kitsu.models.kitsu.KitsuModel
import javax.inject.Inject

class AnimeRepository @Inject constructor(private val service: AnimeApiService) : BaseRepository() {

    fun fetchAnime() : LiveData<PagingData<KitsuModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false,
                initialLoadSize = 2
            ),
            pagingSourceFactory = {
                AnimePagingSources(service)
            }, initialKey = 1
        ).liveData
    }
}