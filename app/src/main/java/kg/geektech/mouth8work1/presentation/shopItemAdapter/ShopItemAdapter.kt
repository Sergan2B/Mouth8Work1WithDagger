package kg.geektech.mouth8work1.presentation.shopItemAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kg.geektech.mouth8work1.R
import kg.geektech.mouth8work1.domain.shopItemModels.ShopItem
import kg.geektech.mouth8work1.presentation.shopItemAdapter.ShopItemAdapter.ViewHolder
import kg.geektech.mouth8work1.utils.ShopListDiffCallback

class ShopItemAdapter : RecyclerView.Adapter<ViewHolder>() {
    //getItemView подсказка

    var list = listOf<ShopItem>()
        set(value) {
            val callback = ShopListDiffCallback(list, value)
            val diffResult = DiffUtil.calculateDiff(callback)
            diffResult.dispatchUpdatesTo(this)
            field = value
        }

    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_task_enable, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shopItem = list[position]
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
        holder.itemView.setOnLongClickListener {
            getItemViewType(R.layout.item_task_disable)
            onShopItemLongClickListener?.invoke(shopItem)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvCount: TextView = itemView.findViewById(R.id.tv_count)
    }
}