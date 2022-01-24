package com.example.shoeinventorymanagement.ui.shoes.list

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeinventorymanagement.R
import com.example.shoeinventorymanagement.ShoeApplication
import com.example.shoeinventorymanagement.data.Shoe
import java.util.*
import kotlin.collections.ArrayList

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private lateinit var shoeListRecyclerView: RecyclerView
    private lateinit var shoeListAdapter : ShoeListAdapter

    private var application = ShoeApplication()
    private val shoeListViewModel : ShoeListViewModel by viewModels {
        ShoeListViewModelFactory((application).repository)
    }

    private var tempArrayList: ArrayList<Shoe> = arrayListOf<Shoe>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.shoe_list_fragment, container, false)

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        shoeListAdapter = ShoeListAdapter(tempArrayList)

        shoeListRecyclerView = view.findViewById(R.id.shoeListRecyclerView)
        shoeListRecyclerView.hasFixedSize()
        shoeListRecyclerView.layoutManager = LinearLayoutManager(view.context)
        shoeListRecyclerView.adapter = shoeListAdapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        shoeListViewModel.allShoes.observe(viewLifecycleOwner) { shoes ->
            tempArrayList.addAll(shoes)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_menu, menu)
        val item = menu?.findItem(R.id.search_by_id)

        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())

                if (searchText.isNotEmpty()) {
                    shoeListViewModel.allShoes.observe(viewLifecycleOwner) { shoes ->
                        shoes.forEach { shoe ->
                            if (shoe.id.toLowerCase(Locale.getDefault()).contains(searchText)) {
                                tempArrayList.add(shoe)
                            }
                        }
                    }
                    shoeListRecyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    tempArrayList.clear()
                    shoeListViewModel.allShoes.observe(viewLifecycleOwner) { shoes ->
                        shoes.let {
                            tempArrayList.addAll(it)
                        }
                    }
                    shoeListRecyclerView.adapter!!.notifyDataSetChanged()
                }

                return false
            }
        })

        // May not need this, but leaving it here for now
//        super.onCreateOptionsMenu(menu, inflater)
    }

}