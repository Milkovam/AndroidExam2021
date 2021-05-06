package no.kristiania.myapplication.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.BuyOrSellFragmentBinding
import java.util.*

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
                switch.replace(R.id.fragment_container, TransactionFragment())
                switch.commit()
            }
        }
    }



    }