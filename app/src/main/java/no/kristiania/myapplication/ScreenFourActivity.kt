package no.kristiania.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class ScreenFourActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screenfour)
        val id: String? = intent.getStringExtra("id")
        var nameOfCoin = findViewById<TextView>(R.id.cryptoDescription)
        nameOfCoin.text = id
        var button = findViewById<Button>(R.id.buttonBuy)
        button.setOnClickListener {
            Intent(ScreenFourActivity@ this, BuyActivity::class.java).also { intent ->
                startActivity(intent)

            }
            var button = findViewById<Button>(R.id.buttonSell)
            button.setOnClickListener {
                Intent(ScreenFourActivity@ this, SellActivity::class.java).also { intent ->
                    startActivity(intent)

                }


            }
        }
    }
}
