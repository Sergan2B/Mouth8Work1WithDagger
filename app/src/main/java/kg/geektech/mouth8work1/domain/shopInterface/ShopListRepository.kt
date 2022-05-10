package kg.geektech.mouth8work1.domain.shopInterface

import androidx.lifecycle.LiveData
import kg.geektech.mouth8work1.domain.shopItemModels.ShopItem

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem

    // Can change (LiveData)
    fun getShopList(): LiveData<List<ShopItem>>
}