package com.example.apptablayouttest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.apptablayouttest.databinding.MainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var binding: MainFragmentBinding
    private val model: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonMainFrg.setOnClickListener {
            model.star.value = StarModel(
                R.drawable.yellow_stars,
                "A yellow supergiant (YSG) is a star, generally of spectral type F or G, " +
                        "having a supergiant luminosity class (e.g. Ia or Ib). They are stars that" +
                        "have evolved away from the main sequence, expanding and becoming more luminous." +
                        "Yellow supergiants are smaller than red supergiants; naked eye examples" +
                        "include Polaris. Many of them are variable stars, mostly pulsating Cepheids" +
                        "such as δ Cephei itself.",
                "Yellow supergiants have a relatively narrow range of temperatures corresponding" +
                        " to their spectral types, from about 4,000 K to 7,000 K.[9] Their luminosities " +
                        "range from about 1,000 L☉ upwards, with the most luminous stars exceeding " +
                        "100,000 L☉. The high luminosities indicate that they are much larger than the sun, " +
                        "from about 30 R☉ to several hundred R☉.[10]" +
                        "The masses of yellow supergiants vary greatly, from less than the sun for " +
                        "stars such as W Virginis to 20 M☉ or more (e.g. V810 Centauri). Corresponding " +
                        "surface gravities (log(g) cgs) are around 1–2 for high-mass supergiants, but " +
                        "can be as low as 0 for low-mass supergiants.[9][11]" +
                        "Yellow supergiants are rare stars, much less common than red supergiants and " +
                        "main sequence stars. In M31 (Andromeda Galaxy), 16 yellow supergiants are seen " +
                        "associated with evolution from class O stars, of which there are around " +
                        "25,000 visible.[12] "
            )
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.placeHolder, ContentFragment.newInstance()).commit()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
            }
}