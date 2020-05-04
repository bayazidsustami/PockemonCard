package com.example.pockemoncard.ui.main

import com.example.pockemoncard.data.PokemonSet

data class MainViewState (
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<PokemonSet>? = null
)