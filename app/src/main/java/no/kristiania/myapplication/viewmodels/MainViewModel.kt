package no.kristiania.myapplication.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import no.kristiania.myapplication.models.CryptoCurrencies
import no.kristiania.myapplication.repos.CryptoRepo

class MainViewModel : ViewModel(){
    val liveStats = MutableLiveData<List<CryptoCurrencies>>()
    private var repo = CryptoRepo()

    fun refresh() {
        viewModelScope.launch {


            val result = withContext(Dispatchers.IO){
                repo.getCryptoCurrenciesSummary()
            }
            liveStats.value = result
        }

    }
}