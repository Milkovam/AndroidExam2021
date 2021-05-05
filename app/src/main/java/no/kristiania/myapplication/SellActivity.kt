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

        binding= ActivitySellBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.sellNow.setOnClickListener{

            //Todo add record to SQLite Database using Room

            finish()

        }

        binding.editUSD.addTextChangedListener(textWatcher)
        binding.editCrypto.addTextChangedListener(textWatcher)

    }

    var textWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {

            binding.sellNow.isEnabled = binding.editCrypto.text.isNotEmpty() && binding.editUSD.text.isNotEmpty()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }




    }
}