package com.asnk.fdcentral.ui.foods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asnk.fdcentral.domain.model.FoodEntry
import com.asnk.fdcentral.ui.databinding.ItemFoodBinding
import com.asnk.fdcentral.ui.widgets.setOnSafeClickListener


/**
 * RecyclerView Adapter to display *food*.
 *
 * @property list the list of foods in this Adapter.
 * @property onStarClick is the item click listener.
 */
class FoodAdapter(
    private val list: ArrayList<FoodEntry>,
    private val onStarClick: (details: FoodEntry, view: View) -> Unit
) : RecyclerView.Adapter<FoodAdapter.StarHolder>() {

    /**
     * RecyclerView ViewHolder to display a Food item.
     *
     * @property binding the binding class item layout.
     */
    inner class StarHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        /**
         * Method to bind data to layout.
         */
        fun bind(item: FoodEntry) {
            binding.item = item
            binding.position = adapterPosition
            binding.root.setOnSafeClickListener {
                onStarClick.invoke(item, binding.profPic)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFoodBinding.inflate(inflater, parent, false)
        return StarHolder(binding)
    }

    override fun onBindViewHolder(holder: StarHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    /**
     * Method to update the data set of adapter.
     */
    fun update(newList: List<FoodEntry>) {
        list.clear()
        list.addAll(newList)
        notifyItemRangeChanged(0, list.size)
    }
}