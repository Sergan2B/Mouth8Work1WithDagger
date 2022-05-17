package kg.geektech.mouth8work1.presentation.shopItemAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.mouth8work1.R
import kg.geektech.mouth8work1.domain.model.ShopItem
import kg.geektech.mouth8work1.presentation.shopItemAdapter.ShopItemAdapter.ViewHolder
import kg.geektech.mouth8work1.utils.ShopItemDiffCallback


class ShopItemAdapter : ListAdapter<ShopItem, ViewHolder>(ShopItemDiffCallback()) {
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLE -> R.layout.item_task_enable
            VIEW_TYPE_DISABLE -> R.layout.item_task_disable
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
        holder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            return@setOnLongClickListener true
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            VIEW_TYPE_ENABLE
        } else {
            VIEW_TYPE_DISABLE
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvCount: TextView = itemView.findViewById(R.id.tv_count)
    }

    companion object {
        const val VIEW_TYPE_ENABLE = 101
        const val VIEW_TYPE_DISABLE = 100
    }
}