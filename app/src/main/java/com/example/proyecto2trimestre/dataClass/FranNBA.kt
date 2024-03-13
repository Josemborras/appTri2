package com.example.proyecto2trimestre.dataClass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FranNBA(
    val logo: Int,
    val nombre: String,
    val nick: String,
    val titulos: Int,
    val conferencia: String,
    val color: String,
    val roster: List<Player>
): Parcelable


