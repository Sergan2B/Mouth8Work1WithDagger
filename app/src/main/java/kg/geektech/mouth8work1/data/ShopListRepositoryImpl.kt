package kg.geektech.mouth8work1.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kg.geektech.mouth8work1.domain.shopItemModels.ShopItem
import kg.geektech.mouth8work1.domain.shopInterface.ShopListRepository

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = sortedSetOf<ShopItem>({ element1, element2 -> element1.id.compareTo(element2.id) })
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    //LD it's live data
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
        shopItem.enabled = !shopItem.enabled
    }

    override fun getShopItem(shopItemId: Int): ShopItem { //= shopList[shopItemId]
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with ID $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}