package com.example.pockemoncard.data.repository.card

import com.example.pockemoncard.data.PokemonCard
import com.example.pockemoncard.data.repository.BaseRepository

class PokemonCardRepository private constructor(): BaseRepository<PokemonCardDataStore>(){
    suspend fun getPokemons(set: String): MutableList<PokemonCard>? {
        val cache = localDataStore?.getPokemon(set)
        if (cache != null) return cache

        val response = remoteDataStore?.getPokemon(set)
        localDataStore?.addAll(set, response)
        return response
    }

    companion object{
        val instance by lazy { PokemonCardRepository() }
    }
}