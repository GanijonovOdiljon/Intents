package com.example.intent.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name :  String,
    val Lastname: String,
    val Age: Int
):Parcelable{
    override fun toString(): String {
        return "User(name='$name', Lastname='$Lastname', Age=$Age)"
    }
}