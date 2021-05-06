package no.kristiania.myapplication

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import no.kristiania.myapplication.adapters.TransactionAdapter
import no.kristiania.myapplication.databinding.ActivityScreen3Binding
import no.kristiania.myapplication.db.TransactionDAO
import no.kristiania.myapplication.db.entities.Transaction
import no.kristiania.myapplication.viewmodels.TransactionListViewModel

class ScreenThreeActivity : AppCompatActivity() {

    private lateinit var listAdapter: TransactionAdapter
    private lateinit var transactionDAO: TransactionDAO

    private val viewModel = TransactionListViewModel()


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        val binding = ActivityScreen3Binding.inflate(layoutInflater)
        setContentView(R.layout.activity_screen3)


        viewModel.init(this)

        val transactionList: List<Transaction> = transactionDAO.fetchAll()
        listAdapter = TransactionAdapter(transactionList)


        binding.sTransactionContainer.apply {
            adapter = listAdapter
        }


    }


}