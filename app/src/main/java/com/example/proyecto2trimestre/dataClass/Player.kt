package com.example.proyecto2trimestre.dataClass

import android.os.Parcelable

@kotlinx.parcelize.Parcelize
data class Player(
    val name: String,
    val number: String,
    val position: String,
    val height: String,
    val weight: String,
    val birthdate: String,
    val age: Int,
    val experience: Int

): Parcelable




