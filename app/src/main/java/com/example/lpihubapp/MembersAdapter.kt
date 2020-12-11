package com.example.lpihubapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


 class MembersAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
     override fun getItem(position: Int): Fragment {

         val fragmentList : MutableList<Fragment> = ArrayList()

         when (position) {
             0 -> return DetailsFragment()

             1 -> return ActivitiesFragment()
         }


         return fragmentList [position]
     }

     override fun getCount(): Int {
         return 2
     }

     override fun getPageTitle(position: Int): CharSequence? {
         when (position) {
             0 -> return "DETAILS"
             1 -> return "ACTIVITIES"

         }

         return null

     }
 }