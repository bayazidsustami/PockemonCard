package com.example.pockemoncard.data.repository.sets

import android.util.Log
import com.example.pockemoncard.data.PokemonSet
import com.example.pockemoncard.data.repository.BaseRepository

class PokemonSetRepository private constructor() : BaseRepository<PokemonSetDataStore>(){
    suspend fun getSets(): MutableList<PokemonSet>?{
        val cache = localDataStore?.getSets()
        if (cache != null) return  cache
        val response = remoteDataStore?.getSets()
        localDataStore?.addAll(response)
        return response
    }

    companion object{
        val instance by lazy { PokemonSetRepository() }
    }
}