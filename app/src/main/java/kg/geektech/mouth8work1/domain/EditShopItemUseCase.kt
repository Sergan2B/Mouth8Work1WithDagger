package kg.geektech.mouth8work1.domain

class EditShopItemUseCase(private val shopEditRepository: ShopListRepository) {
    fun editShopItem(shopItem: ShopItem) {
        shopEditRepository.editShopItem(shopItem)
    }
}