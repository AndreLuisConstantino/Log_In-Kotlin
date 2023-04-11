package br.senai.sp.jandira.login_signup.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.login_signup.model.User

@Database(entities = [User::class], version = 1)
abstract class TripDb : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        private lateinit var instanceDb: TripDb

        //Verifica se a instanciua já está inicializada
        fun getDataBase(context: Context): TripDb {

            if (!::instanceDb.isInitialized){ //:: -> testa se a instancia já está verificada
                instanceDb = Room.databaseBuilder(
                    context,
                    TripDb::class.java,
                    "db_trip"
                ).allowMainThreadQueries().build()
            }

            return instanceDb
        }

    }


}