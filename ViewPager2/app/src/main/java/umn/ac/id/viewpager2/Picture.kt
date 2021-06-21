package umn.ac.id.viewpager2

import com.google.gson.annotations.SerializedName

class Picture (
    @SerializedName("id")
    val id: Int,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,

    @SerializedName("download_url")
    val downloadUrl: String
)