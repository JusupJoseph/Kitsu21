package com.example.kitsu.ui.fragments.manga

import androidx.paging.InvalidatingPagingSourceFactory
import com.example.kitsu.base.BaseViewModel
import com.example.kitsu.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repository: MangaRepository
) :
    BaseViewModel() {
    fun fetchManga() = repository.fetchManga()
}