package com.example.lpihubapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        members.setOnClickListener(){
            startActivity(Intent(this, Members::class.java))
        }
        activitylog.setOnClickListener(){
            startActivity(Intent(this, MembersActivity::class.java))
        }

        add_members.setOnClickListener(){
            startActivity(Intent(this, RegisterNewMembers::class.java))
        }

        notifications.setOnClickListener(){
            startActivity(Intent(this, Notifications::class.java))
        }

        scan.setOnClickListener(){
            startActivity(Intent(this, ScanMainActivity::class.java))
        }
    }
}