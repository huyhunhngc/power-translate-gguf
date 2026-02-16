package com.dotsdev.powertranslator.data.api

import com.dotsdev.powertranslator.data.model.HuggingFaceModel
import retrofit2.http.GET
import retrofit2.http.Query

interface HuggingFaceApi {
    @GET("models")
    suspend fun getModels(
        @Query("search") search: String = "translategemma-4b-it-GGUF",
        @Query("limit") limit: Int = 50,
        @Query("direction") direction: Int = -1,
        @Query("sort") sort: String = "lastModified",
        @Query("full") full: Boolean = true,
        @Query("config") config: Boolean = true
    ): List<HuggingFaceModel>
}
