package no.kristiania.myapplication.repos

import no.kristiania.myapplication.datasource.DummySource
import no.kristiania.myapplication.datasource.LiveSource
import no.kristiania.myapplication.models.CryptoCurrencies

class CryptoRepo {
    private val liveSource = LiveSource()

    fun getCryptoCurrenciesSummary() : List<CryptoCurrencies>{
        var list = liveSource.getSummary()
        return liveSource.getSummary()
    }
}