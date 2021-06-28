package umn.ac.id.mvpnestedrecycler.model

import com.google.gson.annotations.SerializedName

data class Object (
    val category:String,
   @SerializedName("results") var movies : MutableList<Results>?
)