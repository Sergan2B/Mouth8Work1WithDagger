package kg.geektech.mouth8work1.domain.useCase

import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.domain.interfaceShopItem.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}