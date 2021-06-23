package umn.ac.id.nestedrecyclerapilagi

import com.google.gson.annotations.SerializedName

data class Model (
    val category : String,
    @SerializedName ("results") val movies : ArrayList<ModelKecil>
)