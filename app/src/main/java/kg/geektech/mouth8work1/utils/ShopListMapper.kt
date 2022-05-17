package kg.geektech.mouth8work1.utils

import kg.geektech.mouth8work1.data.model.ShopItemDBModel
import kg.geektech.mouth8work1.domain.model.ShopItem

class ShopListMapper {

    fun mapEntityToDBModel(shopItem: ShopItem) = ShopItemDBModel(
        id = shopItem.id,
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled
    )

    fun mapDBModelToEntity(shopItemDBModel: ShopItemDBModel) = ShopItem(
        id = shopItemDBModel.id,
        name = shopItemDBModel.name,
        count = shopItemDBModel.count,
        enabled = shopItemDBModel.enabled
    )

    fun mapListDBModelToListEntity(shopListDBModel: List<ShopItemDBModel>) = shopListDBModel.map {
        mapDBModelToEntity(it)
    }
}