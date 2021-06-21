package umn.ac.id.trykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import umn.ac.id.trykotlin.adapter.ItemAdapter
import umn.ac.id.trykotlin.data.Datasource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadAffirmations()
        val recycler = findViewById<RecyclerView>(R.id.recycler_view_main)
        recycler.adapter = ItemAdapter(this, myDataset)
        recycler.setHasFixedSize(true)
    }
}