package com.example.pockemoncard.data.repository.sets

import com.example.pockemoncard.data.PokemonSet

class PokemonSetLocalDataStore: PokemonSetDataStore {
    private var caches = mutableListOf<PokemonSet>()
    override suspend fun getSets(): MutableList<PokemonSet>? {
        return if (caches.isNotEmpty()) caches else null
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>?) {
        sets?.let { caches = it }
    }
}