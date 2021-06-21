package umn.ac.id.paginatingapi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_movie.view.*

class AdapterTMDB(private val context: Context, private var resultTheMovieDb: ArrayList<Result>) :
    RecyclerView.Adapter<AdapterTMDB.ViewHolderTheMovieDb>() {

    private val TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTheMovieDb {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        return ViewHolderTheMovieDb(view)
    }

    override fun onBindViewHolder(holder: ViewHolderTheMovieDb, position: Int) {
        val resultItem = resultTheMovieDb[position]
        Picasso
            .get()
            .load("https://image.tmdb.org/t/p/w185${resultItem.poster_path}")
            .into(holder.itemView.image_view_poster_item_movie)
        holder
            ?.itemView
            ?.text_view_title_movie_item_movie
            ?.text = resultItem.original_title
        holder
            ?.itemView
            ?.text_view_vote_average_item_movie
            ?.text = resultItem.vote_average.toString()
        holder
            ?.itemView
            ?.text_view_release_date_value_item_movie
            ?.text = resultItem.release_date
        holder
            ?.itemView
            ?.text_view_overview_value_item_movie
            ?.text = resultItem.overview
    }

    override fun getItemCount(): Int = resultTheMovieDb.size

    fun refreshAdapter(resultTheMovieDb: List<Result>) {
        this.resultTheMovieDb.addAll(resultTheMovieDb)
        notifyDataSetChanged()
        /*notifyItemRangeChanged(0, this.resultTheMovieDb.size)*/
    }

    class ViewHolderTheMovieDb(itemView: View) : RecyclerView.ViewHolder(itemView){}

}