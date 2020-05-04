package com.example.pockemoncard.data.repository.card

import com.example.pockemoncard.data.PokemonCard
import com.example.pockemoncard.network.PokemonTcgService

class PokemonCardRemoteDataStore(private val pokemonTcgService: PokemonTcgService): PokemonCardDataStore {
    override suspend fun getPokemon(set: String): MutableList<PokemonCard>? {
        val response = pokemonTcgService.getCards(set)
        if (response.isSuccessful) return  response.body()?.cards

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun addAll(set: String, pokemons: MutableList<PokemonCard>?) {
        TODO("Not yet implemented")
    }
}