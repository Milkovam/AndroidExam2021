package no.kristiania.myapplication.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.BuyOrSellFragmentBinding

class BuyOrSellFragment: Fragment(R.layout.buy_or_sell_fragment) {

    private lateinit var binding: BuyOrSellFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = BuyOrSellFragmentBinding.bind(view)
        initViewListener()


    }

    private fun initViewListener() {
        with(binding){
            buttonBuy.setOnClickListener{
                val switch = activity?.supportFragmentManager!!.beginTransaction()
                switch.replace(R.id.fragment_container, BuyFragment())
                switch.commit()
            }

            buttonSell.setOnClickListener{
                val switch = activity?.supportFragmentManager!!.beginTransaction()
                switch.replace(R.id.fragment_container, SellFragment())
                switch.commit()
            }
        }
    }



    }