package com.okujajoshua.daggernavhost.ui.userdetails


import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.okujajoshua.daggernavhost.R
import com.okujajoshua.daggernavhost.data.Result
import com.okujajoshua.daggernavhost.databinding.UserDetailsFragmentBinding
import com.okujajoshua.daggernavhost.util.hide
import com.okujajoshua.daggernavhost.util.show
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class UserDetailsFragment : Fragment() {
    @Inject
    lateinit var factory: UserDetailsViewModelFactory

    private lateinit var viewModel: UserDetailsViewModel

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding : UserDetailsFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.user_details_fragment,container, false)

        //from navigation argument bundle
        val args = UserDetailsFragmentArgs.fromBundle(requireArguments())

        viewModel = ViewModelProvider(this, factory).get(UserDetailsViewModel::class.java)

        // Specify the current activity as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.userDetailsViewModel = viewModel

        viewModel.searchUser(args.username).observe(viewLifecycleOwner, Observer { result ->
            Log.d("fukk1",result.status.toString())
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    Log.d("fukk2",result.data.toString())
                    result.data?.let {
                        Log.d("fukk",it.name)
                        binding.fullName.text = it.name
                        binding.numOfRepos.text = "Public Repos: ${it.number_of_repos}"
                    }
                }
                Result.Status.LOADING -> binding.progressBar.show()
                Result.Status.ERROR -> {
                    binding.progressBar.hide()
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
