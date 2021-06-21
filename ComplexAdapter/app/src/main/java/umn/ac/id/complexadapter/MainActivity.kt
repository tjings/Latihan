package umn.ac.id.complexadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var mainArrayList = ArrayList<ModelBesar>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addmainData()
        recyclerBesar.layoutManager = LinearLayoutManager(this)
        recyclerBesar.adapter = AdapterBesar(mainArrayList)

    }

    fun addmainData() {
        val subArrayList1 = ArrayList<ModelKecil>()
        val sub1 = ModelKecil("Kecil1")
        val sub2 = ModelKecil("Kecil2")
        val sub3 = ModelKecil("Kecil3")
        val sub4 = ModelKecil("Kecil4")
        val sub5 = ModelKecil("Kecil5")
        val sub6 = ModelKecil("Kecil6")
        subArrayList1.add(sub1)
        subArrayList1.add(sub2)
        subArrayList1.add(sub3)
        subArrayList1.add(sub4)
        subArrayList1.add(sub5)
        subArrayList1.add(sub6)
        val main1 = ModelBesar("Besar1", subArrayList1)
        mainArrayList.add(main1)
        val main2 = ModelBesar("Besar2", subArrayList1)
        mainArrayList.add(main2)
        val main3 = ModelBesar("Besar3", subArrayList1)
        mainArrayList.add(main3)
        val main4 = ModelBesar("Besar4", subArrayList1)
        mainArrayList.add(main4)
    }
}