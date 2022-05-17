package kg.geektech.mouth8work1.domain.useCase

import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.domain.interfaceShopItem.ShopListRepository

class EditShopItemUseCase(private val shopEditRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem) {
        shopEditRepository.editShopItem(shopItem)
    }
}