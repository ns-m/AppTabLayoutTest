package com.example.apptablayouttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apptablayouttest.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val fragList = listOf(FragmentMonday.newInstance(), FragmentTuesday.newInstance(),
        FragmentWednesday.newInstance(), FragmentThursday.newInstance(), FragmentFriday.newInstance())
    private val fragListTitle = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*binding.tabLayoutWeek.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, "Tab selected: ${tab?.text}", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction().replace(R.id.placeHolder, fragList[tab?.position!!]).commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })*/
        val adapter = ViewPagerAdapter(this, fragList)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayoutWeek, binding.viewPager2){
            tab, pos -> tab.text = fragListTitle[pos]
        }.attach()
    }
}