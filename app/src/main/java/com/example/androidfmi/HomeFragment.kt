package com.example.androidfmi

import android.os.Bundle
import android.view.*
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recylerviewkotlin.MyAdapter
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var newRecylerView : RecyclerView
    private lateinit var newArrayList : ArrayList<News>
    private lateinit var tempArrayList : ArrayList<News>
    lateinit var imageId : Array<Int>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j
        )

        heading = arrayOf(
            "Biden aims to expand vaccines for adults and children",
            "Just got my first shot, helping the world to be a safer place",
            "Local trains to be suspended in Bengal from tomorrow in view of covid-19",
            "MHA asks states,UTs to ensure there are no fires in hospitals",
            "Australian citizen sues PM Morrison over flight ban from india",
            "Former India hockey coach Kaushik hospitalised after testing positive for COVID",
            "Delhi records 20,960 fresh covid-19 infections, positivity rate at 26.37%",
            "Barcelona church offers open-air space for Ramadan",
            "Trillions of cicadas set to emerge in the US, here's why",
            "Homemaker, economist: Candidates from all walks of life in Bengal assembly"
        )

        news = arrayOf(

            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        newRecylerView = view.findViewById(R.id.recyclerView)
        newRecylerView.layoutManager = LinearLayoutManager(view.context)
        newRecylerView.setHasFixedSize(true)

        newArrayList = arrayListOf()
        tempArrayList = arrayListOf()
        getUserData()

        newRecylerView.adapter = MyAdapter(newsList = tempArrayList)
        return view

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search,menu)
        val item = menu.findItem(R.id.search_action)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText = newText!!.lowercase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    newArrayList.forEach{item ->
                        if(item.heading.lowercase(Locale.getDefault()).contains(searchText))
                            tempArrayList.add(item)
                    }
                }
                else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                }

                newRecylerView.adapter!!.notifyDataSetChanged()
                return false
            }

        })
        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun getUserData() {
        for(i in imageId.indices){
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }
        tempArrayList.addAll(newArrayList)
    }

}