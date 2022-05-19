package kg.geektech.mouth8work1.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.geektech.mouth8work1.data.model.ShopItemDBModel

@Dao
interface ShopItemDao {

    @Query("SELECT * FROM shop_item")
    fun getAll(): LiveData<List<ShopItemDBModel>>
/*
    @Query("SELECT * FROM shop_item WHERE id = :id")
    fun getShopItem(id: Int)*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItem(shopItemDBModel: ShopItemDBModel)

    @Delete
    suspend fun deleteShopItem(shopItemDBModel: ShopItemDBModel)

    @Update
    suspend fun editShopItem(shopItemDBModel: ShopItemDBModel)
/*
    @Query("SELECT * FROM shop_item ORDER BY name ASC")
    fun sortShopItem(): LiveData<List<ShopItemDBModel>>*/
}