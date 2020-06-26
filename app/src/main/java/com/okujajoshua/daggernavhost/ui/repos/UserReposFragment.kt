package com.okujajoshua.daggernavhost.ui.repos


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okujajoshua.daggernavhost.Api

import com.okujajoshua.daggernavhost.R
import com.okujajoshua.daggernavhost.databinding.UserReposFragmentBinding
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepository
import com.okujajoshua.daggernavhost.repositories.repos.ReposRepositoryImpl
import dagger.android.support.AndroidSupportInjection
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class UserReposFragment : Fragment() {
    @Inject
    lateinit var factory: ReposViewModelFactory

    private lateinit var viewModel: ReposViewModel

//    private lateinit var retrofit: Retrofit
//    private lateinit var api: Api
//
//    private lateinit var reposRepository: ReposRepository

    private lateinit var repos: RecyclerView
    private lateinit var reposAdapter: ReposAdapter

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:UserReposFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.user_repos_fragment,container, false)

        val args = UserReposFragmentArgs.fromBundle(requireArguments())

        binding.setLifecycleOwner(viewLifecycleOwner)

        reposAdapter = ReposAdapter(listOf())

        binding.root.findViewById<RecyclerView>(R.id.repos).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = reposAdapter
        }

//        retrofit = Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        api = retrofit.create(Api::class.java)
//
//        reposRepository =
//            ReposRepositoryImpl(
//                api
//            )

        //factory = ReposViewModelFactory(reposRepository)

        viewModel = ViewModelProvider(this, factory).get(ReposViewModel::class.java)

        viewModel.repos.observe(viewLifecycleOwner, Observer { repositories ->
            reposAdapter.updateRepos(repositories)
        })

        viewModel.getRepos(args.username)

        return binding.root
    }


}
