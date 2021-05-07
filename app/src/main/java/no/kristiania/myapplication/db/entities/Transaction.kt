package no.kristiania.myapplication.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "transaction_table")
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "amountUSD")
    val amountUSD: Int,
    @ColumnInfo(name = "amountCoin")
    val amountCoin: Int,
    @ColumnInfo(name = "coin")
    val coin: String,
    @ColumnInfo(name = "bought")
    val bought: Boolean
)