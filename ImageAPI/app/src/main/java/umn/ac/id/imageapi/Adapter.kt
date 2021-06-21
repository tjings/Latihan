package umn.ac.id.imageapi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pict.view.*

class Adapter(private val context : Context, private val dataSet: List<Picture>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pict, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("test", "${dataSet[position].downloadUrl}")
        Picasso.get().load("${dataSet[position].downloadUrl}").into(holder.itemView.iv1)
        holder.itemView.tv1.text = "${dataSet[position].id}"
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}