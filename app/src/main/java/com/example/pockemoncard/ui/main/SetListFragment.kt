package com.example.pockemoncard.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.pockemoncard.R
import com.example.pockemoncard.adapter.SetListAdapter
import com.example.pockemoncard.data.PokemonSet
import com.example.pockemoncard.data.repository.sets.PokemonSetRepository
import kotlinx.android.synthetic.main.fragment_set_list.*

/**
 * A simple [Fragment] subclass.
 */
class SetListFragment : Fragment() {

    private lateinit var vm: MainViewModel
    private lateinit var adapter: SetListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SetListAdapter()
        rvSet.adapter = adapter

        val factory = SetListFactory(PokemonSetRepository.instance)
        vm = ViewModelProviders.of(this, factory).get(MainViewModel::class.java).apply {
            viewState.observe(viewLifecycleOwner, Observer(this@SetListFragment::handleState))
            Log.d("Response", getSets().toString())
            srlSet.setOnRefreshListener{getSets()}
        }
    }

    private fun handleState(viewState: MainViewState?) {
        viewState?.let {
            toggleLoading(it.loading)
            it.data?.let { data -> showData(data) }
            it.error?.let { error -> showError(error) }
        }
    }

    private fun showData(data: MutableList<PokemonSet>){
        adapter.updateData(data)
        tvSetError.visibility = View.GONE
        rvSet.visibility = View.VISIBLE
    }

    private fun showError(error: Exception){
        tvSetError.text = error.message
        tvSetError.visibility = View.VISIBLE
        rvSet.visibility = View.GONE
    }

    private fun toggleLoading(loading: Boolean){
        srlSet.isRefreshing = loading
    }
}
