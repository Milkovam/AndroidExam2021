package no.kristiania.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import no.kristiania.myapplication.adapters.CryptoCurrenciesListAdapter
import no.kristiania.myapplication.listeners.OnCryptoClickListener
import no.kristiania.myapplication.models.CryptoCurrencies


class ScreenFourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenfour)
        var button = findViewById<Button>(R.id.buttonBuy)
        button.setOnClickListener {
            Intent(ScreenFiveActivity@ this, BuyActivity::class.java).also { intent ->
                startActivity(intent)

            }
        }
    }
}
