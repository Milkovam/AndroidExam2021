package no.kristiania.myapplication.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.ItemTransactionsViewBinding
import no.kristiania.myapplication.viewmodels.TransactionListViewModel

class TransactionListFragment : Fragment(R.layout.item_transactions_view) {

    private lateinit var binding: ItemTransactionsViewBinding

    companion object{
        fun newInstance() = TransactionListFragment()
    }



    private val viewModel: TransactionListViewModel by viewModels()

}