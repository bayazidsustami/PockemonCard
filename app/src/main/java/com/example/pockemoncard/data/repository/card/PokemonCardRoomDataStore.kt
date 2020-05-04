package com.example.pockemoncard.data.repository.card

import com.example.pockemoncard.data.PokemonCard
import com.example.pockemoncard.data.database.PokemonCardDao

class PokemonCardRoomDataStore(private val pokemonCardDao: PokemonCardDao): PokemonCardDataStore {
    override suspend fun getPokemon(set: String): MutableList<PokemonCard>? {
        val response = pokemonCardDao.getAll(set)
        return if (response.isEmpty()) null else response
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
        pokemons?.let { pokemonCardDao.insertAll(*it.toTypedArray()) }
    }
}