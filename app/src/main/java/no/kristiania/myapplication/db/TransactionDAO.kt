package no.kristiania.myapplication.db

import androidx.room.*
import no.kristiania.myapplication.db.entities.Transaction



@Dao
interface TransactionDAO{

    @Insert
    suspend fun insert(transaction: Transaction)

    @Update
    suspend fun update(transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    @Query("select * from transaction_table order by id")
    suspend fun fetchData() : List<Transaction>

}
