package no.kristiania.myapplication.datasource.retrofit

import retrofit2.http.GET
import retrofit2.Call

interface CryptoApi {
    @GET("summary")
    fun getSummary(): Call <SummaryResponse>
}