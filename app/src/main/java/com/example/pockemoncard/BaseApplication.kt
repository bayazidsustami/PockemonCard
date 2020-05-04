package com.example.pockemoncard

import android.app.Application
import com.example.pockemoncard.data.database.AppDatabase
import com.example.pockemoncard.data.repository.card.PokemonCardRemoteDataStore
import com.example.pockemoncard.data.repository.card.PokemonCardRepository
import com.example.pockemoncard.data.repository.card.PokemonCardRoomDataStore
import com.example.pockemoncard.data.repository.sets.PokemonSetRemoteDataStore
import com.example.pockemoncard.data.repository.sets.PokemonSetRepository
import com.example.pockemoncard.data.repository.sets.PokemonSetRoomDataStore
import com.example.pockemoncard.network.RetrofitApp

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val pokemonTcgService = RetrofitApp.POKEMON_TCG_SERVICE
        val appDatabase = AppDatabase.getInstance(this)
        PokemonSetRepository.instance.apply {
            init(
                PokemonSetRoomDataStore(appDatabase.pokemonSetDao()),
                PokemonSetRemoteDataStore(pokemonTcgService))
        }

        PokemonCardRepository.instance.apply {
            init(
                PokemonCardRoomDataStore(appDatabase.pokemonCardDao()),
                PokemonCardRemoteDataStore(pokemonTcgService))
        }
    }
}