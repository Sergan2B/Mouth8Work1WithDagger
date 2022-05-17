package kg.geektech.mouth8work1.presentation.main

import androidx.lifecycle.ViewModel
import kg.geektech.mouth8work1.data.repository.ShopListRepositoryImpl
import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.domain.useCase.*

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repositoryImpl)
    private val getShopListUseCase = GetShopListUseCase(repositoryImpl)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryImpl)
    private val getShopItemUseCase = GetShopItemUseCase(repositoryImpl)
    val shopListLD = getShopListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = with(shopItem) { copy(enabled = !enabled) }
        editShopItemUseCase.editShopItem(newItem)
    }

    fun getShopItem(shopItem: Int): ShopItem {
        return getShopItemUseCase.getShopItem(shopItem)
    }
}