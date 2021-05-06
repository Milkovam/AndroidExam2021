package no.kristiania.myapplication.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.ActivityBuyBinding
import no.kristiania.myapplication.viewmodels.BuySellViewModel
import java.lang.Integer.parseInt

class TransactionFragment : Fragment(R.layout.activity_buy) {

    private lateinit var binding : ActivityBuyBinding
    private val viewModel : BuySellViewModel by viewModels()




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ActivityBuyBinding.bind(view)

        viewModel.init(requireContext())

        initViewListeners()

/*        val usdEdit = activity?.findViewById<TextView>(R.id.editUSD)
        val listenUsdEdit = usdEdit?.addTextChangedListener(textWatcher)
        val cryptoText = activity?.findViewById<TextView>(R.id.textCrypto)
        if (cryptoText != null) {
            cryptoText.text = listenUsdEdit.toString()
        }*/
    }

    private fun initViewListeners(){
        with(binding){

            val coinName = requireActivity().findViewById<TextView>(R.id.cryptoDescription).text

            buyNow.setOnClickListener{
                viewModel.saveDate(
                    parseInt(editUSD.text.toString()),
                    2323.232,
                    coinName.toString(),
                    bought = true)
                Log.d("saved", "saved to DB")

            }
        }
    }
    var textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {

        }
    }

}

