package com.asnk.fdcentral.ui.foods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asnk.fdcentral.domain.model.FoodItemEntity
import com.asnk.fdcentral.ui.databinding.ItemFoodBinding
import com.asnk.fdcentral.ui.widgets.setOnSafeClickListener


/**
 * RecyclerView Adapter to display *food*.
 *
 * @property list the list of foods in this Adapter.
 * @property onStarClick is the item click listener.
 */
class FoodAdapter(
    private val list: ArrayList<FoodItemEntity>,
    private val onStarClick: (details: FoodItemEntity, view: View) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFoodBinding.inflate(inflater, parent, false)
        return FoodHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    /**
     * Method to update the data set of adapter.
     */
    fun update(newList: List<FoodItemEntity>) {
        list.clear()
        list.addAll(newList)
        notifyItemRangeChanged(0, list.size)
    }

    /**
     * RecyclerView ViewHolder to display a Food item.
     *
     * @property binding the binding class item layout.
     */
    inner class FoodHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Method to bind data to layout.
         */
        fun bind(itemEntity: FoodItemEntity) {
            binding.item = itemEntity
            binding.position = adapterPosition
            binding.root.setOnSafeClickListener {
                onStarClick.invoke(itemEntity, binding.profPic)
            }
        }
    }
}