package com.example.gamechronicle

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Games(
    val title: String,
    val overview: String,
    val image: Int,
    val detail: String
) :Parcelable
