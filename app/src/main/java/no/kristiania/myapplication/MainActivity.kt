package no.kristiania.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.recyclerview.widget.LinearLayoutManager
import no.kristiania.myapplication.adapters.CryptoCurrenciesListAdapter
import no.kristiania.myapplication.databinding.ActivityMainBinding
import no.kristiania.myapplication.listeners.OnCryptoClickListener
import no.kristiania.myapplication.models.CryptoCurrencies
import no.kristiania.myapplication.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(),OnCryptoClickListener {


    private lateinit var listAdapter: CryptoCurrenciesListAdapter
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.btnTop
        button.setOnClickListener{
            val intent = Intent(this, ScreenThreeActivity::class.java)
            startActivity(intent)
        }

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

        val intent= Intent(this, ScreenFourActivity::class.java)
        intent.putExtra("id", crypto[position])
        startActivity(intent) }

}

