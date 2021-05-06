package no.kristiania.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.squareup.picasso.Picasso
import no.kristiania.myapplication.fragments.TransactionFragment
import no.kristiania.myapplication.models.CryptoCurrencies


class ScreenFourActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenfour)

        //Intent
        val id = intent.getSerializableExtra("id") as CryptoCurrencies
        val nameOfCoin = findViewById<TextView>(R.id.cryptoDescription)
        val coinImg = findViewById<ImageView>(R.id.symbolImg)
        val priceText = findViewById<TextView>(R.id.priceText)
        nameOfCoin.text = id.name + "(" + id.symbol + ")"
        priceText.text = "$" + id.priceUsd.toString()
        Picasso.get().load("https://static.coincap.io/assets/icons/${id.symbol}@2x.png").into(coinImg)

        val bundle = Bundle().apply {
            putString(id.name, "coinName")
        }




        //Button
        val button = findViewById<Button>(R.id.buttonBuy)
            button.setOnClickListener {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container_transaction,
                        TransactionFragment.newInstance(bundle.toString()), "TransactionFragment")
                    .commit()

/*        val button = findViewById<Button>(R.id.buttonSell)
            button.setOnClickListener {
                Intent(this, SellActivity::class.java).also { intent ->
                    startActivity(intent)

                }*/


            }
        }
    }
