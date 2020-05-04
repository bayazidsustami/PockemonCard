package com.example.pockemoncard.data.repository.card

import com.example.pockemoncard.data.PokemonCard

interface PokemonCardDataStore {
    suspend fun getPokemon(set: String): MutableList<PokemonCard>?
    suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?)
}