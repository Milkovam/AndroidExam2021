package no.kristiania.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import no.kristiania.myapplication.adapters.CryptoCurrenciesListAdapter
import no.kristiania.myapplication.databinding.ActivityMainBinding
import no.kristiania.myapplication.datasource.DummySource
import no.kristiania.myapplication.models.CryptoCurrencies
import no.kristiania.myapplication.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

   private  lateinit var listAdapter:  CryptoCurrenciesListAdapter
   private val viewModel=MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listAdapter= CryptoCurrenciesListAdapter(ArrayList<CryptoCurrencies>())


        binding.recyclerView.layoutManager =LinearLayoutManager(this)
        binding.recyclerView.adapter=listAdapter

        viewModel.liveStats.observe(this,{ list->
            listAdapter.update(list)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }
}