package com.example.lpihubapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_members2.*

class MembersActivity : AppCompatActivity() {

//    lateinit var tabLayout: TabLayout
//    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_members2)

    viewPager.adapter = MembersAdapter(supportFragmentManager)
    tabLayout.setupWithViewPager(viewPager)

    tabLayout.setTabTextColors(Color.GRAY, Color.parseColor("white"))

//        title = "KotlinApp"
//        tabLayout = findViewById(R.id.tabLayout)
//        viewPager = findViewById(R.id.viewPager)
//        tabLayout.addTab(tabLayout.newTab().setText("Details"))
//        tabLayout.addTab(tabLayout.newTab().setText("Activities"))
//        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
//        val adapter = MembersAdapter(this, supportFragmentManager,
//            tabLayout.tabCount)
//        viewPager.adapter = adapter
//        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                viewPager.currentItem = tab.position
//            }
//            override fun onTabUnselected(tab: TabLayout.Tab) {}
//            override fun onTabReselected(tab: TabLayout.Tab) {}
//        })
    }
}

