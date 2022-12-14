package com.example.kitsu.ui.fragments.anime

import com.example.kitsu.base.BaseViewModel
import com.example.kitsu.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(private val repository: AnimeRepository) :
    BaseViewModel() {

    fun fetchAnime() = repository.fetchAnime()
}