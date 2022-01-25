package com.example.shoeinventorymanagement.ui.shoes.list.filter

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import com.example.shoeinventorymanagement.R

class FilterOptions : Fragment() {

    companion object {
        fun newInstance() = FilterOptions()
    }

    private lateinit var viewModel: FilterOptionsViewModel
    private lateinit var brandsExpandList: ExpandableListView
    private lateinit var typesExpandList: ExpandableListView

    private var brandArrayList: ArrayList<String> = arrayListOf<String>()
    private var typeArrayList: ArrayList<String> = arrayListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.filter_options_fragment, container, false)

        brandsExpandList = view.findViewById(R.id.list_brands)
        brandsExpandList.adapter = ExpandableListAdapter()

        typesExpandList = view.findViewById(R.id.list_types)


        // !!!!!!!!!!!!!!!!!!!!!
        // DO STUFF TO VIEW HERE
        // !!!!!!!!!!!!!!!!!!!!!

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FilterOptionsViewModel::class.java)

        viewModel.allShoes.observe(viewLifecycleOwner) { shoes ->
            var brands = arrayListOf<String>()
            var types = arrayListOf<String>()
            shoes.forEach { shoe ->
                brands.add(shoe.brand)
                types.add(shoe.type)
            }
            brands.toSet().toList()
            types.toSet().toList()
            brands.sort()
            types.sort()
        }
    }

}