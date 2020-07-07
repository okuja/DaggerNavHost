package com.okujajoshua.daggernavhost.ui.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController

import com.okujajoshua.daggernavhost.R
import com.okujajoshua.daggernavhost.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : HomeFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.home_fragment,container, false)

        binding.setLifecycleOwner (this)


        binding.search.setOnClickListener {view: View ->
            view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToUserDetailsFragment (username.text.toString())
            )

            Log.d("search",username.text.toString())
        }

        binding.viewRepos.setOnClickListener {view: View ->
            view.findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToUserReposFragment (username.text.toString())
            )

        }


        return binding.root
    }


}
