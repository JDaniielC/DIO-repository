package com.example.kotlinstudies.domain
import com.google.gson.annotations.SerializedName
data class Team(
    @SerializedName("nome")
    val name: String,
    @SerializedName("forca")
    val starts: Int,
    @SerializedName("imagem")
    val image: String
)