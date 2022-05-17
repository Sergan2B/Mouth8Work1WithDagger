package kg.geektech.mouth8work1.domain.useCase

import androidx.lifecycle.LiveData
import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.domain.interfaceShopItem.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}