package kg.geektech.mouth8work1.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kg.geektech.mouth8work1.App
import kg.geektech.mouth8work1.domain.interfaceShopItem.ShopListRepository
import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.utils.ShopListMapper

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList =
        sortedSetOf<ShopItem>({ element1, element2 -> element1.id.compareTo(element2.id) })
    private val mapper = ShopListMapper()

    override fun addShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().addShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().deleteShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun editShopItem(shopItem: ShopItem) {
        App.db.shopItemDao().editShopItem(mapper.mapEntityToDBModel(shopItem))
    }

    override fun getShopItem(shopItemId: Int): ShopItem { //= shopList[shopItemId]
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with ID $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        App.db.shopItemDao().getAll()) {
        mapper.mapListDBModelToListEntity(it)
    }
}