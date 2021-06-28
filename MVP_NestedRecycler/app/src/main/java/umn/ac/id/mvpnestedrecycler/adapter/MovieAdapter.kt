package umn.ac.id.mvpnestedrecycler.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_layout_movie.view.*
import umn.ac.id.mvpnestedrecycler.R
import umn.ac.id.mvpnestedrecycler.model.Results

class MovieAdapter(
    val movieList: MutableList<Results>?
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind (position: Int){
            itemView.tv_title.text = "${movieList?.get(position)?.title}"
            Picasso
                .get()
                .load("https://image.tmdb.org/t/p/w185/${movieList?.get(position)?.poster_path}")
                .into(itemView.image_view_movie)
            itemView.tv_genre.text = "${movieList?.get(position)?.overview}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position = position)
    }

    override fun getItemCount(): Int {
        return movieList?.size?:0
    }
}
