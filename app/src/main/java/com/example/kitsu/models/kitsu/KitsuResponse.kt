package com.example.kitsu.models.kitsu

import com.example.kitsu.models.Links
import com.example.kitsu.models.Meta
import com.google.gson.annotations.SerializedName

data class KitsuResponse<T>(
    @SerializedName("data")
    val result: List<KitsuModel>,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("links")
    val links: Links
)