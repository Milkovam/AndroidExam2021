package no.kristiania.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import no.kristiania.myapplication.databinding.ActivityBuyBinding
import no.kristiania.myapplication.models.CryptoCurrencies

class BuyActivity : AppCompatActivity() {

    lateinit var binding: ActivityBuyBinding

    lateinit var list: List <CryptoCurrencies>

    fun giveList(): List<CryptoCurrencies> {
        return list
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityBuyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buyNow.setOnClickListener{

            //Todo add record to SQLite Database using Room

            finish()

        }

        fun bind(stats: CryptoCurrencies) {

            binding.textCrypto.text="${stats.priceUsd}"

        }

        fun update(newList: List<CryptoCurrencies>){
            list = newList


        }


        binding.editUSD.addTextChangedListener(textWatcher)

    }

    var textWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {

            binding.buyNow.isEnabled =  binding.editUSD.text.isNotEmpty()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }




    }
}