package no.kristiania.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import no.kristiania.myapplication.adapters.CryptoCurrenciesListAdapter
import no.kristiania.myapplication.listeners.OnCryptoClickListener
import no.kristiania.myapplication.models.CryptoCurrencies
import org.w3c.dom.Text


class ScreenFourActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenfour)

        var text = findViewById<TextView>(R.id.cryptoDescription)

        var ID: String? = intent.getStringExtra("list")

        text.text = ID




    }


}