package com.example.shoeinventorymanagement.ui.shoes.add

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.fragment.app.viewModels
import com.example.shoeinventorymanagement.R
import com.example.shoeinventorymanagement.ShoeApplication
import com.example.shoeinventorymanagement.data.Shoe
import com.example.shoeinventorymanagement.data.ShoeDao
import com.example.shoeinventorymanagement.ui.shoes.list.ShoeListViewModel
import java.lang.RuntimeException
import java.util.UUID

class AddShoeFragment : Fragment() {

    private lateinit var addBrandView : EditText
    private lateinit var addTypeView : EditText
    private lateinit var addPriceView : EditText
    private lateinit var saveBtn : Button

    companion object {
        fun newInstance() = AddShoeFragment()
    }

    private var application = ShoeApplication()
    private val addShoeViewModel: AddShoeViewModel by viewModels {
        AddShoeViewModelFactory((application).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.add_shoe_fragment, container, false)

        addBrandView = view.findViewById(R.id.add_brand)
        addTypeView = view.findViewById(R.id.add_type)
        addPriceView = view.findViewById(R.id.add_price)
        saveBtn = view.findViewById(R.id.button_save)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        saveBtn.setOnClickListener {
            val replyIntent = Intent()
            if (
                TextUtils.isEmpty(addBrandView.text)
                || TextUtils.isEmpty(addBrandView.text)
                || TextUtils.isEmpty(addBrandView.text)
            ) {
                Toast.makeText(
                    context,
                    "Please enter all fields.",
                    Toast.LENGTH_SHORT
                )
            } else {
                val shoeID : String = UUID.randomUUID().toString()
                val brand : String = addBrandView.text.toString()
                val type : String = addTypeView.text.toString()
                val price : Int = addPriceView.text.toString().toInt()

                val shoe = Shoe(shoeID, brand, type, price)

                addShoeViewModel.insert(shoe)

            }
        }
    }

}
