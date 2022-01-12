package com.example.shoeinventorymanagement.ui.shoes.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.shoeinventorymanagement.R

class AddShoeFragment : Fragment() {

    private lateinit var addBrandView : EditText
    private lateinit var addTypeView : EditText
    private lateinit var addPriceView : EditText

    companion object {
        fun newInstance() = AddShoeFragment()
    }

    private lateinit var viewModel: AddShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.add_shoe_fragment, container, false)

        addBrandView = view.findViewById(R.id.add_brand)
        addTypeView = view.findViewById(R.id.add_type)
        addPriceView = view.findViewById(R.id.add_price)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(AddShoeViewModel::class.java)
//        // TODO: Use the ViewModel
    }

}