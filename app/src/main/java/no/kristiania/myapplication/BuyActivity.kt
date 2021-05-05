package no.kristiania.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import no.kristiania.myapplication.databinding.ActivityBuyBinding
import androidx.lifecycle.MutableLiveData
import android.widget.TextView
import com.squareup.picasso.Picasso
import no.kristiania.myapplication.models.CryptoCurrencies
import org.w3c.dom.Text
import retrofit2.Retrofit

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


        /// GET VALUE FROM DATABASE FIRST. AND THEN CALCULATE NOT THE OTHER WAY AROUND :D
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