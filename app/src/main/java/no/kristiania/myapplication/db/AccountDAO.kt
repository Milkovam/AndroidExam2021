package no.kristiania.myapplication.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import no.kristiania.myapplication.db.entities.Account


@Dao
interface AccountDAO{

    @Insert
    fun insert(account: Account)

    @Update
    fun update(account: Account)

    @Delete
    fun delete(account: Account)
}