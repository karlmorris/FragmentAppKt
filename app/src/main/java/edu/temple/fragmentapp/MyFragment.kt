package edu.temple.fragmentapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider

class MyFragment : Fragment() {

    lateinit var spinner: Spinner
    lateinit var layout: View
    lateinit var viewModelProvider: ViewModelProvider

    var startupIndex : Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startupIndex = arguments?.getInt("startupIndex", 0)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_my, container, false)

        spinner = layout.findViewById(R.id.spinner)

        spinner.adapter = ArrayAdapter(requireContext()
            , android.R.layout.simple_spinner_dropdown_item
            , requireContext().resources.getStringArray(R.array.colors))

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModelProvider.get(ColorViewModel::class.java).setColor(p0?.getItemAtPosition(p2).toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        return layout
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelProvider = ViewModelProvider(requireActivity())

        changeColor(startupIndex)
    }

    fun changeColor(index: Int?) {
        if (index != null) {
            spinner.setSelection(index)
        }
    }

    companion object {
        fun getInstance (index : Int) : MyFragment {
            val fragment = MyFragment()
            val bundle: Bundle = Bundle()
            bundle.putInt("startupIndex", index)
            fragment.arguments = bundle
            return fragment
        }
    }
}