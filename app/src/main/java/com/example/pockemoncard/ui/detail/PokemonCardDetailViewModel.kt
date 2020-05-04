package com.example.pockemoncard.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pockemoncard.data.PokemonCard

class PokemonCardDetailViewModel: ViewModel() {
    private val mViewState = MutableLiveData<PokemonCardDetailViewState>().apply {
        value = PokemonCardDetailViewState(null)
    }

    val viewState: LiveData<PokemonCardDetailViewState>
        get() = mViewState

    fun setData(pokemonCard: PokemonCard){
        mViewState.value = mViewState.value?.copy(data = pokemonCard)
    }
}