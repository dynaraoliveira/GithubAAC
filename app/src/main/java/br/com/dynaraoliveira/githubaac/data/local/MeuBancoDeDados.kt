package br.com.dynaraoliveira.githubaac.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import br.com.dynaraoliveira.githubaac.data.local.converter.DateConverter
import br.com.dynaraoliveira.githubaac.data.local.dao.UserDao
import br.com.dynaraoliveira.githubaac.data.local.entity.User

@Database(entities = [User::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class MeuBancoDeDados: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private val INSTANCE: MeuBancoDeDados? = null
    }
}