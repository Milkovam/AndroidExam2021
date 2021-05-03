package no.kristiania.myapplication.datasource.retrofit

import com.google.gson.GsonBuilder
import no.kristiania.myapplication.models.CryptoCurrencies
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class CryptoApiClient {
    private var cryptoApi : CryptoApi
    init {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://api.coincap.io/v2/assets")
            .build()

        cryptoApi = retrofit.create(CryptoApi::class.java)
    }


    }


