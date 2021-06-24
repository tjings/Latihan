package umn.ac.id.mvpnestedrecycler.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_layout_home.view.*
import umn.ac.id.mvpnestedrecycler.Model.Model
import umn.ac.id.mvpnestedrecycler.R

class HomeAdapter(
    var movie: List<Model>
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_layout_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_movie_category.text = movie.get(position).category
        holder.itemView.home_recycler_view_horizontal.apply {
            layoutManager = LinearLayoutManager(
                holder.itemView.home_recycler_view_horizontal.context,
                RecyclerView.HORIZONTAL,
                false
            )
            adapter = MovieAdapter(movie[position].movies)
        }
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}