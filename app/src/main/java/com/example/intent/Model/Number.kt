package com.example.intent.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Number(
    val name : String,
    val salary : Double
):Parcelable{
    override fun toString(): String {
        return "Number(name='$name', salary=$salary)"
    }
}