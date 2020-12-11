package com.example.lpihubapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_all.*
import kotlinx.android.synthetic.main.fragment_all.view.*


class AllFragment : Fragment() {
    private var mAdapter: AllListAdapter? = null
    private var allList: ArrayList<All>? = arrayListOf()
    // private var layoutManager: RecyclerView.LayoutManager? = null

    private var mLayoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mLayoutManager = LinearLayoutManager(this.context)
        mAdapter = this.context?.let { AllListAdapter(allList!!, it) }
        val view = inflater.inflate(R.layout.fragment_all, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        all_recycler.apply {
            layoutManager = mLayoutManager
            adapter = mAdapter
            allList!!.add(All("Alex Marchal", "alexmar@gmail.com", R.drawable.user_picture))
            allList!!.add(All("Alex Marchal", "alexmar@gmail.com", R.drawable.user_picture))
            allList!!.add(All("Alex Marchal", "alexmar@gmail.com", R.drawable.user_picture))
            allList!!.add(All("Alex Marchal", "alexmar@gmail.com", R.drawable.user_picture))
            allList!!.add(All("Alex Marchal", "alexmar@gmail.com", R.drawable.user_picture))

}}}