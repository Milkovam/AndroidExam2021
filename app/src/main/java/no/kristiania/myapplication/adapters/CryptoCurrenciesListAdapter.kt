package no.kristiania.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import no.kristiania.myapplication.databinding.ItemCryptocurrenciesViewBinding
import no.kristiania.myapplication.models.CryptoCurrencies
import com.squareup.picasso.Picasso
import no.kristiania.myapplication.listeners.OnCryptoClickListener


class CryptoCurrenciesListAdapter (private var list: List <CryptoCurrencies>,
                                   private val onCryptoClickListener:
                                   OnCryptoClickListener)
    : RecyclerView.Adapter<CryptoCurrenciesListAdapter.CryptoViewHolder>(){
    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int): CryptoViewHolder {

        return CryptoViewHolder(ItemCryptocurrenciesViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    fun giveList(): List<CryptoCurrencies> {
        return list
    }


    override fun onBindViewHolder(holder: CryptoCurrenciesListAdapter.CryptoViewHolder, position: Int) {
       holder.bind(list[position])


        holder.itemView.setOnClickListener{
            onCryptoClickListener.onCryptoItemClicked(position)

        }
    }

    override fun getItemCount(): Int = list.size

class CryptoViewHolder(private val binding: ItemCryptocurrenciesViewBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(stats:CryptoCurrencies){
       Picasso.get().load("https://static.coincap.io/assets/icons/${stats.symbol.toLowerCase()}@2x.png").into(binding.iconView)
        binding.textViewCryptoCases.text=stats.name
        binding.textViewCryptoPrice.text="${stats.priceUsd}"
        binding.symbol.text=stats.symbol
        binding.percentChange.text="${stats.changePercent24Hr}"




    }
}
    fun update(newList: List<CryptoCurrencies>){
        list = newList
        notifyDataSetChanged()
    }
}