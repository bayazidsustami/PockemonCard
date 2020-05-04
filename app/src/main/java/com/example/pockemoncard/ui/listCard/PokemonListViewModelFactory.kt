package com.example.pockemoncard.ui.listCard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pockemoncard.data.repository.card.PokemonCardRepository
import java.lang.IllegalArgumentException

class PokemonListViewModelFactory(private val repository: PokemonCardRepository)
    :ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java))
            return PokemonListViewModel(repository) as T

        throw IllegalArgumentException()
    }
}