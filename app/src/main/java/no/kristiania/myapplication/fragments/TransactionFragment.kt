package no.kristiania.myapplication.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.ActivityBuyBinding
import no.kristiania.myapplication.viewmodels.BuySellViewModel
import java.lang.Integer.parseInt

class TransactionFragment : Fragment(R.layout.activity_buy) {

    private lateinit var binding : ActivityBuyBinding
    private val viewModel : BuySellViewModel by viewModels()

    private var coinName: String? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            coinName = requireArguments().getString(coinName)
        }

        binding = ActivityBuyBinding.bind(view)

        viewModel.init(requireContext())

        initViewListeners()

    }

    private fun initViewListeners(){
        with(binding){
            //val amountCoin = parseInt(coinPrice.toString()) / parseInt(editUSD.toString())
            buyNow.setOnClickListener{
                viewModel.saveDate(
                    parseInt(editUSD.text.toString()),
                    33.23123123122,
                    coinName.toString(),
                    bought = true)

            }
        }
    }

    companion object{
        private val coinName = "coinName"

        fun newInstance(nameOfCoin: String): TransactionFragment{
            val fragment = TransactionFragment()
            val args = Bundle()
            args.putString(coinName, nameOfCoin)
            fragment.arguments = args

            return fragment

        }
    }

}