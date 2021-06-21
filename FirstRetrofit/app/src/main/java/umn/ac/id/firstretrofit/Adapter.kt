package umn.ac.id.firstretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post.view.*

class Adapter(private val context : Context, private val dataSet: List<PostModel>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.userId.text = "${dataSet[position].userid}"
        holder.itemView.postId.text = "${dataSet[position].id}"
        holder.itemView.title.text = dataSet[position].title
        holder.itemView.body.text = dataSet[position].body
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}