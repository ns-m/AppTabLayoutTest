package com.example.apptablayouttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apptablayouttest.databinding.FragmentCharacteristicsBinding

class FragmentCharacteristics : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentCharacteristicsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCharacteristicsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.star.observe(viewLifecycleOwner){
            binding.textViewLayChrct.text = it.infoDetails
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentCharacteristics()
            }
}