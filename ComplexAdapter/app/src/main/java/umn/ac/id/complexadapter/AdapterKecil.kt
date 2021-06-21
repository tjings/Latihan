package umn.ac.id.complexadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.kecil.view.*

class AdapterKecil(val listItemKecil: ModelBesar) : RecyclerView.Adapter<AdapterKecil.ViewHolderKecil>() {
    class ViewHolderKecil(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderKecil {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.kecil, parent, false)
        return ViewHolderKecil(view)
    }

    override fun onBindViewHolder(holder: ViewHolderKecil, position: Int) {
        holder.itemView.tv_cardview.text = listItemKecil.listKecil!!.get(position).titleKecil
    }

    override fun getItemCount(): Int {
        return listItemKecil.listKecil!!.size
    }

}
