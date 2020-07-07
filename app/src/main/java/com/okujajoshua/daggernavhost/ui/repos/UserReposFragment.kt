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
import com.google.android.material.snackbar.Snackbar
import com.okujajoshua.daggernavhost.R
import com.okujajoshua.daggernavhost.databinding.UserReposFragmentBinding
import com.okujajoshua.daggernavhost.data.Result
import com.okujajoshua.daggernavhost.util.hide
import com.okujajoshua.daggernavhost.util.show
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class UserReposFragment : Fragment() {
    @Inject
    lateinit var factory: ReposViewModelFactory

    private lateinit var viewModel: ReposViewModel

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


        viewModel = ViewModelProvider(this, factory).get(ReposViewModel::class.java)



        viewModel.repos(args.username).observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.hide()
                    result.data?.let { reposAdapter.updateRepos(it) }
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


}
