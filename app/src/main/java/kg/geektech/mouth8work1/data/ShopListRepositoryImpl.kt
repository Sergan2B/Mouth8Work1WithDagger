package kg.geektech.mouth8work1.data

import kg.geektech.mouth8work1.domain.ShopItem
import kg.geektech.mouth8work1.domain.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId--
        }
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        shopItem.enabled = !shopItem.enabled
    }

    override fun getShopItem(shopItemId: Int): ShopItem = shopList[shopItemId]

    override fun getShopList(): List<ShopItem> = shopList.toList()
}