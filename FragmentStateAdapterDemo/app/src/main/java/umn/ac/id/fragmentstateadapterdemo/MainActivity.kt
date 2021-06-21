package umn.ac.id.fragmentstateadapterdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragments : ArrayList<Fragment> = arrayListOf(
            Page1(),
            Page2()
        )

        val adapter = ViewPagerAdapter(fragments, this)
        view_pager.adapter = adapter
    }
}