package com.example.pockemoncard.ui.listCard

import com.example.pockemoncard.data.PokemonCard

data class PokemonListViewState(
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<PokemonCard>? = null
)