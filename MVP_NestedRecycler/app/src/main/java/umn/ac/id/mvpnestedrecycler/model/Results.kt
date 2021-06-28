package umn.ac.id.mvpnestedrecycler.model

data class Results(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val title: String,
    val release_date : String,
    val adult : Boolean
)