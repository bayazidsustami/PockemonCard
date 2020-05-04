package com.example.pockemoncard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pockemoncard.R
import com.example.pockemoncard.data.PokemonCard
import com.example.pockemoncard.ui.listCard.PokemonListFragmentDirections
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_pokemon.*

class PokemonListAdapter: RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {
    private val pokemonCard = mutableListOf<PokemonCard>()

    fun updateData(newPokemonCards: MutableList<PokemonCard>) {
        pokemonCard.clear()
        pokemonCard.addAll(newPokemonCards)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false))
    }

    override fun getItemCount(): Int = pokemonCard.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pokemonCard[position])
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View
            get() = itemView

        fun bindItem(pokemonCard: PokemonCard){

            Glide.with(containerView)
                .load(pokemonCard.image)
                .into(ivCardLogo)

            tvCardName.text = pokemonCard.name
            tvCardRarity.text = pokemonCard.rarity

            containerView.setOnClickListener { view ->
                val action = PokemonListFragmentDirections.actionPokemonListFragmentToPokemonCardDetailFragment(
                    pokemonCard, pokemonCard.name!!
                )

                view.findNavController().navigate(action)
            }
        }
    }
}