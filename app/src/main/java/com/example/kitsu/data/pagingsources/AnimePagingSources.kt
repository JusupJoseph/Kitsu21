package com.example.kitsu.data.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kitsu.data.remote.apiservices.anime.AnimeApiService
import com.example.kitsu.data.remote.apiservices.manga.MangaApiService
import com.example.kitsu.models.kitsu.KitsuModel
import retrofit2.HttpException
import java.io.IOException

class AnimePagingSources(
    private val service: AnimeApiService
    ) : PagingSource<Int, KitsuModel>() {

        override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, KitsuModel> {
            val position = params.key ?: 1
            val pageLimit = 20
            val pageOffset = position - 1


            return try {
                val response = service.fetchAnime(pageLimit, pageOffset)
                val nextPage = response.links.next
                val nextPageNumber =
                    if (nextPage == null) null
                    else position + pageLimit

                PagingSource.LoadResult.Page(
                    data = response.result,
                    prevKey = null,
                    nextKey = nextPageNumber
                )

            } catch (exception: IOException) {
                return PagingSource.LoadResult.Error(exception)
            } catch (exception: HttpException) {
                return PagingSource.LoadResult.Error(exception)
            }
        }

        override fun getRefreshKey(state: PagingState<Int, KitsuModel>): Int? {
            return state.anchorPosition?.let {
                val anchorPage = state.closestPageToPosition(anchorPosition = it)
                anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
            }
        }
    }