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
import com.okujajoshua.daggernavhost.Api
import com.okujajoshua.daggernavhost.R
import com.okujajoshua.daggernavhost.databinding.UserDetailsFragmentBinding
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepository
import com.okujajoshua.daggernavhost.repositories.userdetails.UserRepositoryImpl
import dagger.android.support.AndroidSupportInjection
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UserDetailsFragment : Fragment() {
    @Inject
    lateinit var factory: UserDetailsViewModelFactory

    private lateinit var viewModel: UserDetailsViewModel

    private lateinit var retrofit: Retrofit
    private lateinit var api: Api

    private lateinit var userRepository: UserRepository

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

        Log.d("UserDetailsViewModel","okuja")

//        retrofit = Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        api = retrofit.create(Api::class.java)
//
//        userRepository =UserRepositoryImpl( api )

        //factory = UserDetailsViewModelFactory( userRepository )

        viewModel = ViewModelProvider(this, factory).get(UserDetailsViewModel::class.java)

        // Specify the current activity as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = this

        // Set the viewmodel for databinding - this allows the bound layout access
        // to all the data in the ViewModel
        binding.userDetailsViewModel = viewModel

        viewModel.user.observe(viewLifecycleOwner, Observer { user ->
            binding.fullName.text = user.name
            binding.numOfRepos.text = "Public Repos: ${user.repos}"
        })

        viewModel.searchUser(args.username)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
