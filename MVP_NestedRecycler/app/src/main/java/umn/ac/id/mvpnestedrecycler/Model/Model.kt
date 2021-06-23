package umn.ac.id.mvpnestedrecycler.Model

import com.google.gson.annotations.SerializedName

data class Model (
    val category:String,
   @SerializedName("results") val movies : ArrayList<ModelKecil>
)