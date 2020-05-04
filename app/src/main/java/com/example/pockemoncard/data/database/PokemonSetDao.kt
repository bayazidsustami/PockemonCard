package com.example.pockemoncard.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.pockemoncard.data.PokemonSet

@Dao
interface PokemonSetDao {
    @Query("SELECT * FROM PokemonSet")
    suspend fun getAll(): MutableList<PokemonSet>

    @Query("DELETE FROM PokemonSet")
    suspend fun deleteAll()

    @Insert
    suspend fun insertAll(vararg pokemonSet: PokemonSet)
}