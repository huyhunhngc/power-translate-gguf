package com.dotsdev.powertranslator.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dotsdev.powertranslator.data.api.HuggingFaceApi
import com.dotsdev.powertranslator.data.model.HuggingFaceModel

class HuggingFacePagingSource(
    private val api: HuggingFaceApi
) : PagingSource<Int, HuggingFaceModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, HuggingFaceModel> {
        return try {
            val page = params.key ?: 0
            val limit = params.loadSize
            val response = api.getModels(limit = limit)
            LoadResult.Page(
                data = response,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, HuggingFaceModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
