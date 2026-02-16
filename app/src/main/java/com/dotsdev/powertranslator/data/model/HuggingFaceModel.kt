package com.dotsdev.powertranslator.data.model

import com.google.gson.annotations.SerializedName

data class HuggingFaceModel(
    @SerializedName("id") val id: String,
    @SerializedName("likes") val likes: Int,
    @SerializedName("downloads") val downloads: Int,
    @SerializedName("tags") val tags: List<String>,
    @SerializedName("pipeline_tag") val pipelineTag: String?,
    @SerializedName("library_name") val libraryName: String?,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("modelId") val modelId: String
)
