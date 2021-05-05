package no.kristiania.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel

import androidx.recyclerview.widget.LinearLayoutManager
import no.kristiania.myapplication.adapters.CryptoCurrenciesListAdapter
import no.kristiania.myapplication.databinding.ActivityMainBinding
import no.kristiania.myapplication.datasource.DummySource
import no.kristiania.myapplication.datasource.LiveSource
import no.kristiania.myapplication.datasource.retrofit.CryptoApiClient
import no.kristiania.myapplication.listeners.OnCryptoClickListener
import no.kristiania.myapplication.models.CryptoCurrencies
import no.kristiania.myapplication.viewmodels.MainViewModel
import java.io.Serializable

class MainActivity : AppCompatActivity(),OnCryptoClickListener {


    //private var cryptoList = arrayListOf<CryptoCurrencies>()
    private lateinit var listAdapter: CryptoCurrenciesListAdapter
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listAdapter = CryptoCurrenciesListAdapter(ArrayList<CryptoCurrencies>(),this)



        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = listAdapter
        listAdapter.notifyDataSetChanged()




        viewModel.liveStats.observe(this, { list ->
            listAdapter.update(list)
        })

    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }



    override fun onCryptoItemClicked( position: Int) {

        val crypto = listAdapter.giveList()
        var intent= Intent(this, ScreenFourActivity::class.java)
        intent.putExtra("id", crypto[position].name)
        startActivity(intent) }

}

