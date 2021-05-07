package no.kristiania.myapplication.models

import java.io.Serializable


data class CryptoCurrencies(
    var symbol:String,
    var name:String,
    var priceUsd: Int,
    var changePercent24Hr: Int,
    var id:String) : Serializable


