package kg.geektech.mouth8work1.presentation.mainActivity

import androidx.lifecycle.ViewModel
import kg.geektech.mouth8work1.data.ShopListRepositoryImpl
import kg.geektech.mouth8work1.domain.shopItemModels.ShopItem
import kg.geektech.mouth8work1.domain.shopItemUseCase.*

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
        /*val newItem = ShopItem(
            shopItem.name,
            shopItem.count,
            !shopItem.enabled
        )*/
        with(shopItem) { copy(enabled = !enabled) }
        editShopItemUseCase.editShopItem(shopItem)
    }

    /////ТУТ ОШИБКА. lj 10/05/2022. Не помню была тут ошибка или нет после 10.05.2022
    fun getShopItem(shopItem: Int): ShopItem {
        return getShopItemUseCase.getShopItem(shopItem)
    }
}