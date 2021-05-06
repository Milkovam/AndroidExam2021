package no.kristiania.myapplication.models

import java.io.Serializable


data class CryptoCurrencies(
    var symbol:String,
    var name:String,
    var priceUsd: Float,
    var changePercent24Hr: Float,
    var id:String) : Serializable


