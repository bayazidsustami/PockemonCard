package com.example.pockemoncard.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pockemoncard.data.repository.sets.PokemonSetRepository
import java.lang.IllegalArgumentException

class SetListFactory(private val setRepository: PokemonSetRepository)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(setRepository) as T

        throw IllegalArgumentException()
    }
}