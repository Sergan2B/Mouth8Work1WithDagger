package kg.geektech.mouth8work1.domain.useCase

import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.domain.interfaceShopItem.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}