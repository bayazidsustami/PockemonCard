package com.example.pockemoncard.data.repository.card

import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class PokemonCardRepositoryTest{
    @Mock
    var localCardDataStore: PokemonCardDataStore? = null
    @Mock
    var remoteCardDataStore: PokemonCardDataStore? = null

    var pokemonCardRepository : PokemonCardRepository? = null

    @Before
    fun init(){
        MockitoAnnotations.initMocks(this)
        pokemonCardRepository = PokemonCardRepository.instance.apply {
            init(localCardDataStore!!, remoteCardDataStore!!)
        }
    }

    @Test
    fun shouldNotGetPokemonsFromRemoteWhenLocalIsNotNull() {
        runBlocking {
            `when`(localCardDataStore?.getPokemon(ArgumentMatchers.anyString())).thenReturn(mutableListOf())
            pokemonCardRepository?.getPokemons(ArgumentMatchers.anyString())

            verify(remoteCardDataStore, never())?.getPokemon(ArgumentMatchers.anyString())
            verify(localCardDataStore, never())?.addAll(ArgumentMatchers.anyString(), ArgumentMatchers.any())
        }
    }

    @Test
    fun shouldCallGetPokemonsFromRemoteAndSaveToLocalWhenLocalIsNull() {
        runBlocking {
            `when`(localCardDataStore?.getPokemon(ArgumentMatchers.anyString())).thenReturn(null)
            `when`(remoteCardDataStore?.getPokemon(ArgumentMatchers.anyString())).thenReturn(ArgumentMatchers.any())
            pokemonCardRepository?.getPokemons("Test set")

            verify(remoteCardDataStore, times(1))?.getPokemon(ArgumentMatchers.anyString())
            verify(localCardDataStore, times(1))?.addAll(ArgumentMatchers.anyString(), ArgumentMatchers.any())
        }
    }

    @Test
    fun shouldThrowExceptionWhenRemoteThrowAnException() {
        runBlocking {
            `when`(localCardDataStore?.getPokemon(ArgumentMatchers.anyString())).thenReturn(null)
            `when`(remoteCardDataStore?.getPokemon(ArgumentMatchers.anyString())).thenAnswer { throw Exception()}

            try {
                pokemonCardRepository?.getPokemons("Test set")
            } catch (ex: Exception){

            }
        }
    }
}