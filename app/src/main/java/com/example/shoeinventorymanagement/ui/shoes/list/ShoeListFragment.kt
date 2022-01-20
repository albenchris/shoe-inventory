package com.example.shoeinventorymanagement.ui.shoes.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shoeinventorymanagement.R
import com.example.shoeinventorymanagement.ShoeApplication
import com.example.shoeinventorymanagement.data.Shoe

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private lateinit var shoeListRecyclerView: RecyclerView

    private lateinit var shoeListAdapter : ShoeListAdapter
//    private val shoeListAdapter = ShoeListAdapter()

    private var application = ShoeApplication()
    private val shoeListViewModel : ShoeListViewModel by viewModels {
        ShoeListViewModelFactory((application).repository)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.shoe_list_fragment, container, false)

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

//        shoeListAdapter = ShoeListAdapter(shoeListViewModel.allShoes.value as MutableList<Shoe>)
        shoeListAdapter = ShoeListAdapter()

        shoeListRecyclerView = view.findViewById(R.id.shoeListRecyclerView)
        shoeListRecyclerView.hasFixedSize()
        shoeListRecyclerView.layoutManager = LinearLayoutManager(view.context)
        shoeListRecyclerView.adapter = shoeListAdapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        shoeListViewModel.allShoes.observe(viewLifecycleOwner) { shoes ->
            shoes.let { shoeListAdapter.submitList(it) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.filter_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}