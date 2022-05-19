package kg.geektech.mouth8work1.domain.repository

import androidx.lifecycle.LiveData
import kg.geektech.mouth8work1.domain.model.ShopItem

interface ShopListRepository {
    suspend fun addShopItem(shopItem: ShopItem)
    suspend fun deleteShopItem(shopItem: ShopItem)
    suspend fun editShopItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: Int): ShopItem

    // Can change (LiveData)
    fun getShopList(): LiveData<List<ShopItem>>
}