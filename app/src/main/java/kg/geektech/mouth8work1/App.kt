package kg.geektech.mouth8work1

import android.app.Application
import androidx.room.Room
import kg.geektech.mouth8work1.data.local.AppDataBase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "dataBase")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()
    }

    companion object {
        lateinit var db: AppDataBase
    }
}