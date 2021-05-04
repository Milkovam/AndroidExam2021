package no.kristiania.myapplication.listeners

import java.io.Serializable

interface OnCryptoClickListener  : Serializable {

    fun onCryptoItemClicked(position: Int)
}