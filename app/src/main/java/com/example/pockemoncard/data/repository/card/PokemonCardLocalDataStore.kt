package com.example.pockemoncard.data.repository.card

import com.example.pockemoncard.data.PokemonCard

class PokemonCardLocalDataStore: PokemonCardDataStore {
    private val caches = mutableMapOf<String, MutableList<PokemonCard>?>()
    override suspend fun getPokemon(set: String): MutableList<PokemonCard>? {
        return if (caches.contains(set)) caches[set] else null
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
        caches[set] = pokemons
    }
}