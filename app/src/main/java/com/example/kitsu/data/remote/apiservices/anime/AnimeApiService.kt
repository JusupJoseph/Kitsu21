package com.example.kitsu.data.remote.apiservices.anime

import com.example.kitsu.models.kitsu.KitsuModel
import com.example.kitsu.models.kitsu.KitsuResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int = 20,
        @Query("page[offset]") offset: Int = 0
    ): KitsuResponse<KitsuModel>

}