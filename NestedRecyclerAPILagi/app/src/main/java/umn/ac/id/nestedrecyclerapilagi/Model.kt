package umn.ac.id.nestedrecyclerapilagi

import com.google.gson.annotations.SerializedName

data class Model (
    val page : Int,
    @SerializedName ("results") val movies : ArrayList<ModelKecil>
)