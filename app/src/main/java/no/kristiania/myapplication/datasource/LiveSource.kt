package no.kristiania.myapplication.datasource

import no.kristiania.myapplication.models.CryptoCurrencies
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL


class LiveSource {

    fun getSummary() : List<CryptoCurrencies> {
        val list = ArrayList<CryptoCurrencies>()


        var response = get("https://api.coincap.io/v2/assets")

        if (response.isSuccessful){

            var data=JSONObject(response.body).getJSONArray("data")

            for (i in 0 until data.length()){

                list.add(
                    CryptoCurrencies(
                        data.getJSONObject(i).getString("symbol"),
                        data.getJSONObject(i).getString("name"),
                    ))
            }
        }

        //Todo 1 call endpoint https://api.coincap.io/v2/assets
        //Todo 2 Handle the response
        //TODO 3. Parse the results into list

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
