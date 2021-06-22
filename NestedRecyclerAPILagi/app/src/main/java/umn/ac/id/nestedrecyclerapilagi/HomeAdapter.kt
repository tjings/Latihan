package umn.ac.id.nestedrecyclerapilagi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_layout_home.view.*

class HomeAdapter (val context: Context, var movie : ArrayList<Model>): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    class ViewHolder (view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tv_movie_category.text = movie.get(position).movies.get(position).overview

        val hAdapter = MovieAdapter(movie.get(position))
        holder.itemView.home_recycler_view_horizontal.adapter = hAdapter
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}