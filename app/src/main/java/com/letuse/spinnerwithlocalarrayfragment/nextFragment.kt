package com.letuse.spinnerwithlocalarrayfragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_next.*

class nextFragment : Fragment(), AdapterView.OnItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val gender = listOf("Male","Female")

        val adapter = context?.let { ArrayAdapter.createFromResource(it,R.array.gender,R.layout.list_item) }
        adapter?.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        mySpinner.adapter = adapter
        mySpinner.onItemSelectedListener = this


    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        val text: String = p0?.getItemAtPosition(position).toString()
        textView.text = text

        var one = "Male"
        var two = "Female"

        if(text.equals(one)){
            img.setImageResource(R.drawable.ic_man)
        }else if(text.equals(two)){
            img.setImageResource(R.drawable.ic_woman)
        }
    }


}