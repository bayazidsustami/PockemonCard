package com.example.pockemoncard.network

import com.example.pockemoncard.data.PokemonCard
import com.example.pockemoncard.data.PokemonSet
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonTcgService {
    @GET("cards")
    suspend fun getCards(
        @Query("set") set: String
    ): Response<PokemonCard.PokemonCardResponse>

    @GET("sets")
    suspend fun getSets():Response<PokemonSet.PokemonSetResponse>
}