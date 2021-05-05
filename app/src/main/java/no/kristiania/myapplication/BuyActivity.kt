package no.kristiania.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import no.kristiania.myapplication.databinding.ActivityBuyBinding

class BuyActivity : AppCompatActivity() {

    lateinit var binding: ActivityBuyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding= ActivityBuyBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buyNow.setOnClickListener{

            //Todo add record to SQLite Database using Room

            finish()

        }



       binding.editUSD.addTextChangedListener(textWatcher)
        binding.editCrypto.addTextChangedListener(textWatcher)

    }

    var textWatcher = object : TextWatcher {

        override fun afterTextChanged(s: Editable?) {

            binding.buyNow.isEnabled = binding.editCrypto.text.isNotEmpty() && binding.editUSD.text.isNotEmpty()
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }




    }
}