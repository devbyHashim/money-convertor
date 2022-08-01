package com.example.code.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.code.R
import com.example.code.databinding.FragmentMainBinding
import com.example.code.root.CustomViewModelStateFactory
import com.example.code.root.RootFragment
import com.example.code.ui.adapter.ConversionAdapter
import javax.inject.Inject

class MainFragment : RootFragment(), AdapterView.OnItemSelectedListener  {
    @Inject
    lateinit var progressDialog: ProgressDialog
    @Inject
    lateinit var mainViewModelInjector: MainViewModelInjector
    private val viewModel by lazy {
        val factory = CustomViewModelStateFactory(mainViewModelInjector,requireActivity(),null)
        ViewModelProvider(requireActivity(),factory)[MainViewModel::class.java]
    }

    private val conversionAdapter by lazy {
        ConversionAdapter(requireActivity())
    }
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinner.onItemSelectedListener = this

        ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.planets_array,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            binding.spinner.adapter = adapter
        }


        binding.rvConversions.apply {
            adapter = conversionAdapter
            layoutManager = GridLayoutManager(this.context,4)
        }

        conversionAdapter.updateData(arrayListOf())
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

}