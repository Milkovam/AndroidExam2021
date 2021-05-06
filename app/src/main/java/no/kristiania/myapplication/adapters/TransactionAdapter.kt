package no.kristiania.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import no.kristiania.myapplication.R
import no.kristiania.myapplication.databinding.ItemTransactionsViewBinding
import no.kristiania.myapplication.db.entities.Transaction

class TransactionAdapter(private var allTransactions: List<Transaction>) :
    RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(ItemTransactionsViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(allTransactions[position])
    }

    override fun getItemCount() = allTransactions.size

    class TransactionViewHolder(private val binding: ItemTransactionsViewBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(stats: Transaction){
            binding.transactionItem.text = stats.coin
        }
    }

    fun update(newList: List<Transaction>){
        allTransactions = newList
        notifyDataSetChanged()
    }

}
