package kg.geektech.mouth8work1.domain.model

import javax.inject.Inject

data class ShopItem @Inject constructor(
    val name: String,
    val count: Int,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
