package com.example.pockemoncard.data.repository.sets

import com.example.pockemoncard.data.PokemonSet
import com.example.pockemoncard.data.database.PokemonSetDao

class PokemonSetRoomDataStore(private val pokemonSetDao: PokemonSetDao): PokemonSetDataStore {
    override suspend fun getSets(): MutableList<PokemonSet>? {
        val response = pokemonSetDao.getAll()
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>?) {
        sets?.let { pokemonSetDao.insertAll() }
    }
}