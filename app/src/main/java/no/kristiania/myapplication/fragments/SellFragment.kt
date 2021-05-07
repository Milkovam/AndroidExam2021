package no.kristiania.myapplication.fragments

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.ActivityBuyBinding
import no.kristiania.myapplication.databinding.ActivitySellBinding
import no.kristiania.myapplication.viewmodels.BuySellViewModel

class SellFragment : Fragment(R.layout.activity_sell) {


        private lateinit var binding : ActivitySellBinding
        private val viewModel : BuySellViewModel by viewModels()




        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding = ActivitySellBinding.bind(view)

            viewModel.init(requireContext())

            initViewListeners()

        }

        private fun initViewListeners(){

            with(binding){
                editUSD.addTextChangedListener(textWatcher)


                sellNow.setOnClickListener{
                    val coinName =
                        requireActivity().findViewById<TextView>(R.id.cryptoDescription).text
                    val usd =
                        Integer.parseInt(requireActivity().findViewById<EditText>(R.id.editUSD).text.toString())
                    val price =
                        Integer.parseInt(requireActivity().findViewById<TextView>(R.id.priceText).text.toString())
                    val amountOfCoins = usd / price

                    viewModel.saveDate(
                        Integer.parseInt(editUSD.text.toString()),
                        amountOfCoins,
                        coinName.toString(),
                        bought = false)
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

                val usd = Integer.parseInt(s.toString())
                val price =
                    Integer.parseInt(requireActivity().findViewById<TextView>(R.id.priceText).text.toString())

                binding.textCrypto.text = (usd / price).toDouble().toString()
            }
        }




}