package com.example.apptablayouttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.apptablayouttest.databinding.ContentFragmentBinding
import com.example.apptablayouttest.databinding.MainFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class ContentFragment : Fragment() {
    private lateinit var binding: ContentFragmentBinding
    private val model: MainViewModel by activityViewModels()
    private val fragList = listOf(FragmentDescription.newInstance(), FragmentCharacteristics.newInstance())
    private val fragListTitle = listOf("Description", "Characteristics")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ContentFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        model.star.observe(viewLifecycleOwner){
            binding.imageViewMain.setImageResource(it.imageId)
        }
        val adapter = ViewPagerAdapter(activity as AppCompatActivity, fragList)
        binding.viewPager2.adapter = adapter
        TabLayoutMediator(binding.tabLayoutWeek, binding.viewPager2){
                tab, pos -> tab.text = fragListTitle[pos]
        }.attach()
    }
    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
            }
}