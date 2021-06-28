package umn.ac.id.mvpnestedrecycler.Model

import com.google.gson.annotations.SerializedName

data class Object (
    val category:String,
   @SerializedName("results") var movies : MutableList<Results>?
)