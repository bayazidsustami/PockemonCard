package com.example.pockemoncard.data.repository.sets

import com.example.pockemoncard.data.PokemonSet

interface PokemonSetDataStore {
    suspend fun getSets(): MutableList<PokemonSet>?
    suspend fun addAll(sets: MutableList<PokemonSet>?)
}