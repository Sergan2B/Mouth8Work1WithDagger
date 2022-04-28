package kg.geektech.mouth8work1.domain

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int): ShopItem

    // Can change (LiveData)
    fun getShopList(): List<ShopItem>
}