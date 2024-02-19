package com.juan.aplicacion_bbdd.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juan.aplicacion_bbdd.data.database.entities.QuoteEntity
import com.juan.aplicacion_bbdd.data.network.QuoteDao

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun getQuoteDao(): QuoteDao
}
