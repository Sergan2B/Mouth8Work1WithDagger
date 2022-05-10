package kg.geektech.mouth8work1.domain.shopItemUseCase

import kg.geektech.mouth8work1.domain.shopItemModels.ShopItem
import kg.geektech.mouth8work1.domain.shopInterface.ShopListRepository

class EditShopItemUseCase(private val shopEditRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem) {
        shopEditRepository.editShopItem(shopItem)
    }
}