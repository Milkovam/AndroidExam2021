package no.kristiania.myapplication.viewmodels

import android.content.Context
import android.view.ContextMenu
import android.view.SurfaceControl
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.kristiania.myapplication.db.DataBase
import no.kristiania.myapplication.db.TransactionDAO
import no.kristiania.myapplication.db.entities.Transaction

class TransactionListViewModel : ViewModel() {
    private lateinit var transactionDAO : TransactionDAO

    private val _transactionListLiveData:
            MutableLiveData<List<Transaction>> = MutableLiveData()

    fun init(context: Context){

        transactionDAO = DataBase.getDatabase(context).getTransactionDAO()

        getData()
    }

    internal fun getData(){
        viewModelScope.launch {
            val list = transactionDAO.fetchAll()
            _transactionListLiveData.value = list
        }
    }
}