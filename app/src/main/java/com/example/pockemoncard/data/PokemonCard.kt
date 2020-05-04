package com.example.pockemoncard.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonCard(
    var name: String?,
    @SerializedName("imageUrl") var image: String?,
    var rarity: String?,
    var series: String?,
    var set: String?
) : Parcelable {
    data class PokemonCardResponse(
        var cards: MutableList<PokemonCard>
    )
}