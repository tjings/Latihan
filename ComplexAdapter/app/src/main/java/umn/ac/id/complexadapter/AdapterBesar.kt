package umn.ac.id.complexadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.besar.view.*

class AdapterBesar  (val listItemBesar : ArrayList<ModelBesar>): RecyclerView.Adapter<AdapterBesar.ViewHolderBesar>() {
    class ViewHolderBesar(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterBesar.ViewHolderBesar {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.besar, parent, false)
        return ViewHolderBesar(view)
    }

    override fun onBindViewHolder(holder: AdapterBesar.ViewHolderBesar, position: Int) {
        val itemBesar = listItemBesar[position]

        holder.itemView.tv_besar.text = itemBesar.titleBesar

        val layoutManagerKecil = LinearLayoutManager(holder.itemView.recyclerKecil.context, LinearLayoutManager.HORIZONTAL, false)

        holder.itemView.recyclerKecil.apply {
            layoutManager = layoutManagerKecil
            adapter = AdapterKecil(listItemBesar.get(position))
        }
    }

    override fun getItemCount(): Int = listItemBesar.size

}