package kg.geektech.mouth8work1.domain.shopItemUseCase

import kg.geektech.mouth8work1.domain.shopItemModels.ShopItem
import kg.geektech.mouth8work1.domain.shopInterface.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}