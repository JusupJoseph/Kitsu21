package com.example.kitsu.models.kitsu

import com.example.kitsu.base.IBaseDiffModel
import com.example.kitsu.models.Attributes
import com.google.gson.annotations.SerializedName

data class KitsuModel(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("attributes")
    val attributes: Attributes
): IBaseDiffModel<Int>