package com.example.pockemoncard.data.repository.sets

import com.example.pockemoncard.data.PokemonSet
import com.example.pockemoncard.network.PokemonTcgService

class PokemonSetRemoteDataStore(private val pokemontcgService: PokemonTcgService):
    PokemonSetDataStore {
    override suspend fun getSets(): MutableList<PokemonSet>? {
       val response = pokemontcgService.getSets()
        if (response.isSuccessful) return response.body()?.sets

        throw Exception("Terjadi kesalahan saat melakukan request data, status error ${response.code()}")
    }

    override suspend fun addAll(sets: MutableList<PokemonSet>?) {
        TODO("Not yet implemented")
    }

}