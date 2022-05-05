package com.example.apptablayouttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apptablayouttest.databinding.FragmentDescriptionBinding

class FragmentDescription : Fragment() {
    private val model: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.star.observe(viewLifecycleOwner){
            binding.textViewLayDscrp.text = it.infoGeneral
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = FragmentDescription()
            }
}