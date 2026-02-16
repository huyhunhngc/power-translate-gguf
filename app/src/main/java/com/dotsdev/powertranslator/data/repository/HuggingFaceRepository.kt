package com.dotsdev.powertranslator.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dotsdev.powertranslator.data.api.HuggingFaceApi
import com.dotsdev.powertranslator.data.model.HuggingFaceModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HuggingFaceRepository {

    private val api: HuggingFaceApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://huggingface.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        
        api = retrofit.create(HuggingFaceApi::class.java)
    }

    fun getModels(): Flow<PagingData<HuggingFaceModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { HuggingFacePagingSource(api) }
        ).flow
    }
}
