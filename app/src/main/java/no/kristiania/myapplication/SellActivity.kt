package no.kristiania.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher

import no.kristiania.myapplication.databinding.ActivitySellBinding

class SellActivity : AppCompatActivity() {


    lateinit var binding: ActivitySellBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySellBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonSell.setOnClickListener {


            //Todo add record to SQLite Database using Room

            finish()

        }


        binding.editUSD.addTextChangedListener(textWatcher)


        /// GET VALUE FROM DATABASE FIRST. AND THEN CALCULATE NOT THE OTHER WAY AROUND :D
    }

    var textWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {

            binding.buttonSell.isEnabled = binding.editUSD.text.isNotEmpty()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }
}