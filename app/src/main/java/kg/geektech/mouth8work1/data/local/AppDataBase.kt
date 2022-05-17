package kg.geektech.mouth8work1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kg.geektech.mouth8work1.data.model.ShopItemDBModel

@Database(entities = [ShopItemDBModel::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun shopItemDao(): ShopItemDao
}