package kg.geektech.mouth8work1

import android.app.Application
import androidx.room.Room
import kg.geektech.mouth8work1.data.local.AppDataBase
import kg.geektech.mouth8work1.di.DaggerNewComponent
import kg.geektech.mouth8work1.domain.model.ShopItem
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var shopItem: ShopItem

    init {
        DaggerNewComponent.create().inject(this)
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDataBase::class.java, "dataBase").fallbackToDestructiveMigration().build()
    }


    companion object {
        lateinit var db: AppDataBase
    }
}