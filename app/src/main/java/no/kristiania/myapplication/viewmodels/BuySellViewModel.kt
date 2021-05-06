package no.kristiania.myapplication.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.kristiania.myapplication.db.DataBase
import no.kristiania.myapplication.db.TransactionDAO
import no.kristiania.myapplication.db.entities.Transaction

class BuySellViewModel : ViewModel() {

    private lateinit var transactionDao: TransactionDAO

    private val _transactionLiveData : MutableLiveData<Transaction> = MutableLiveData()
    val transactionLiveData: LiveData<Transaction> = _transactionLiveData

    fun init(context: Context){
        transactionDao = DataBase.getDatabase(context).getTransactionDAO()
        Log.d("database", "database is goood")
    }

    fun saveDate(amountUSD: Int, amountCoin: Double, coin: String, bought: Boolean){
        viewModelScope.launch {
            if(coin.isNotEmpty()){
                transactionDao.insert(Transaction(
                    amountUSD = amountUSD,
                    amountCoin = amountCoin,
                    coin = coin,
                    bought = bought
                ))
            }
        }

    }
}