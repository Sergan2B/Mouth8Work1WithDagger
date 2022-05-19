package kg.geektech.mouth8work1.domain.useCase

import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.domain.repository.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}