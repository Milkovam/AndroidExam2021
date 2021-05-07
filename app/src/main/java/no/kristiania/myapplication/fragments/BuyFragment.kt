package no.kristiania.myapplication.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.ActivityBuyBinding
import no.kristiania.myapplication.viewmodels.BuySellViewModel
import java.lang.Integer.parseInt

class BuyFragment : Fragment(R.layout.activity_buy) {

    private lateinit var binding : ActivityBuyBinding
    private val viewModel : BuySellViewModel by viewModels()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ActivityBuyBinding.bind(view)

        viewModel.init(requireContext())

        initViewListeners()

    }

    private fun initViewListeners(){
        with(binding){


            editUSD.addTextChangedListener(textWatcher)


            buyNow.setOnClickListener{
                val coinName = requireActivity().findViewById<TextView>(R.id.cryptoDescription).text
                val usd = parseInt(requireActivity().findViewById<EditText>(R.id.editUSD).text.toString())
                val price = parseInt(requireActivity().findViewById<TextView>(R.id.priceText).text.toString())
                val amountOfCoins = usd / price



                Log.d("dele på", amountOfCoins.toString())
                viewModel.saveDate(
                    parseInt(editUSD.text.toString()),
                    2323,
                    coinName.toString(),
                    bought = true)
                Log.d("saved", "saved to DB")

            }
        }
    }
    private var textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
            val usd = parseInt(s.toString())
            val price = parseInt(requireActivity().findViewById<TextView>(R.id.priceText).text.toString())

            binding.textCrypto.text = (usd / price).toDouble().toString()

}
}
}

