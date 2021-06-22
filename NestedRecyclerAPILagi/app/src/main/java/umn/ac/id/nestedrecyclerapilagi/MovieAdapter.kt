package umn.ac.id.nestedrecyclerapilagi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout_movie.view.*

class MovieAdapter(
    val movieList: ModelKecil
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_movie, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.tv_title.text = "${movieList.title}"
        Picasso
            .get()
            .load("https://image.tmdb.org/t/p/w185/${movieList.poster_path}")
            .into(holder.itemView.image_view_movie)
        holder.itemView.tv_genre.text = "${movieList.overview}"
    }

    override fun getItemCount(): Int {
        return 1
    }
}
