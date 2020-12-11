package com.example.lpihubapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

@Suppress("DEPRECATION")

internal class MemberAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment {

        val fragmentList : MutableList<Fragment> = ArrayList()
         when (position) {
            0 -> return AllFragment()

            1 -> return LoggedInFragment()


            2 -> return SubscribedFragment()

        }
        return fragmentList [position]
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "All"
            1 -> return "Logged In"
            2 -> return "Subscribed"

        }

        return null

    }
}