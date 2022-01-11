package com.example.shoeinventorymanagement.ui.shoes.list

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeinventorymanagement.R

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private lateinit var shoeListRecyclerView: RecyclerView
    private val shoeListAdapter = ShoeListAdapter()
    private lateinit var viewModel: ShoeListViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.shoe_list_fragment, container, false)

        shoeListRecyclerView = view.findViewById(R.id.shoeListRecyclerView)
        shoeListRecyclerView.hasFixedSize()
        shoeListRecyclerView.layoutManager = LinearLayoutManager(view.context)
        shoeListRecyclerView.adapter = ShoeListAdapter()

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)




//        viewModel = ViewModelProvider(this, )

//        val recyclerView = requireView().findViewById<RecyclerView>(R.id.shoeListRecyclerView)

    }

}