package kg.geektech.mouth8work1.domain.shopItemUseCase

import androidx.lifecycle.LiveData
import kg.geektech.mouth8work1.domain.shopItemModels.ShopItem
import kg.geektech.mouth8work1.domain.shopInterface.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}