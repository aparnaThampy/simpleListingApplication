package com.example.samplelistingapp.data

import com.google.gson.annotations.SerializedName

data class Lists(
    val page: Page
)

data class Page(
    @SerializedName("content-items") val contentItems: ContentItems,
    val pageNum: String,
    val pageSize: String,
    val title: String,
    val totalContentItems: String
)

data class ContentItems(
    val content: List<Content>
)

data class Content(
    val name: String,
    @SerializedName("poster-image") val posterImage: String
)