package no.kristiania.myapplication.datasource

import no.kristiania.myapplication.models.CryptoCurrencies
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL


class LiveSource {

    fun getSummary() : List<CryptoCurrencies> {
        val list = ArrayList<CryptoCurrencies>()


        val response = get("https://api.coincap.io/v2/assets")

        if (response.isSuccessful){

            val data = JSONObject(response.body).getJSONArray("data")

            for (i in 0 until data.length()){

                list.add(
                    CryptoCurrencies(
                        data.getJSONObject(i).getString("symbol"),
                        data.getJSONObject(i).getString("name"),
                        data.getJSONObject(i).getLong("priceUsd").toFloat(),
                        data.getJSONObject(i).getLong("changePercent24Hr").toFloat(),
                        data.getJSONObject(i).getString("id")

                    ))
            }
        }


        return  list

    }


    private fun get(endpointURL: String): HTTPResponse {

        val url = URL(endpointURL)
        val connection = url.openConnection() as HttpURLConnection
        try {
            connection.requestMethod = "GET"

            connection.connect()

            val stream = if (connection.responseCode in 200..300) connection.inputStream else connection.errorStream

            val responseBody = try {
                stream.bufferedReader(Charsets.UTF_8).use { it.readText() }
            } catch (e: Throwable) {
                ""
            }

            return HTTPResponse(connection.responseCode, responseBody)
        } catch (e: Throwable) {
            return HTTPResponse(connection.responseCode, "")
        } finally {
            connection.disconnect()
        }
    }


    class HTTPResponse (private val statusCode: Int, val body : String) {
        val isSuccessful = statusCode in 200..300
    }
}
