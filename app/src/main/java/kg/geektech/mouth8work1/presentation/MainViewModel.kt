package kg.geektech.mouth8work1.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kg.geektech.mouth8work1.data.ShopListRepositoryImpl
import kg.geektech.mouth8work1.domain.*

class MainViewModel : ViewModel() {

    private val repositoryImpl = ShopListRepositoryImpl()

    private val addShopItemUseCase = AddShopItemUseCase(repositoryImpl)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repositoryImpl)
    private val getShopListUseCase = GetShopListUseCase(repositoryImpl)
    private val editShopItemUseCase = EditShopItemUseCase(repositoryImpl)
    private val getShopItemUseCase = GetShopItemUseCase(repositoryImpl)
    val shopListLD = MutableLiveData<List<ShopItem>>()
    val shopListLDItem = MutableLiveData<ShopItem>()

    fun getShopList() {
        shopListLD.value = getShopListUseCase.getShopList()
    }

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
    }

    fun getShopItem(shopItem: Int) {
        shopListLDItem.value = getShopItemUseCase.getShopItem(shopItem)
    }
}