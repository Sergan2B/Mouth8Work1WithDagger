package kg.geektech.mouth8work1.domain.useCase

import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}