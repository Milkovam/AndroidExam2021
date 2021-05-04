package no.kristiania.myapplication.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "account_table")
data class Account(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "balance")
    val balance: Int,

)
/*

@Entity(tableName = "assets")
data class assets(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "symbol")
    val symbol: String,
    @ColumnInfo(name = "amount")
    val amount: Int,
    @ColumnInfo(name = "price")
    val price: Int,
)

@Entity(tableName = "transaction")
data class transaction(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "asset")
    val asset: String,
    @ColumnInfo(name = "sold")
    val sold: Boolean,
    @ColumnInfo(name = "bought")
    val bought: Boolean,
    @ColumnInfo(name = "amount")
    val amount: Int
)*/
