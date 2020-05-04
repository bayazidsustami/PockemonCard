package com.example.pockemoncard

import android.app.Application
import com.example.pockemoncard.data.repository.card.PokemonCardLocalDataStore
import com.example.pockemoncard.data.repository.card.PokemonCardRemoteDataStore
import com.example.pockemoncard.data.repository.card.PokemonCardRepository
import com.example.pockemoncard.data.repository.sets.PokemonSetLocalDataStore
import com.example.pockemoncard.data.repository.sets.PokemonSetRemoteDataStore
import com.example.pockemoncard.data.repository.sets.PokemonSetRepository
import com.example.pockemoncard.network.RetrofitApp

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val pokemonTcgService = RetrofitApp.POKEMON_TCG_SERVICE
        PokemonSetRepository.instance.apply {
            init(PokemonSetLocalDataStore(), PokemonSetRemoteDataStore(pokemonTcgService))
        }

        PokemonCardRepository.instance.apply {
            init(PokemonCardLocalDataStore(), PokemonCardRemoteDataStore(pokemonTcgService))
        }
    }
}