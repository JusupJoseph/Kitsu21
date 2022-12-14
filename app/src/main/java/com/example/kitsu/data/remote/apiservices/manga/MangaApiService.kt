package com.example.kitsu.data.remote.apiservices.manga

import com.example.kitsu.models.kitsu.KitsuModel
import com.example.kitsu.models.kitsu.KitsuResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MangaApiService {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int = 20,
        @Query("page[offset]") offset: Int = 0
    ): KitsuResponse<KitsuModel>
}