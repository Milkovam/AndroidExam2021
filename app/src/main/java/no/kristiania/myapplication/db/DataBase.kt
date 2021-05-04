package no.kristiania.myapplication.db

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import no.kristiania.myapplication.db.entities.Account

const val DATABASE_NAME: String = "account_database"

@Database(entities = [Account::class], version = 1)
abstract class DataBase: RoomDatabase(){
    abstract fun getAccountDAO() : AccountDAO

    companion object{
        var db : DataBase? = null

        fun getDatabase(context : Context) : DataBase {

            val newDB = db?: Room.databaseBuilder(context,
                DataBase::class.java, DATABASE_NAME).build()

            return newDB.also {
                db = it
            }
        }
    }
}