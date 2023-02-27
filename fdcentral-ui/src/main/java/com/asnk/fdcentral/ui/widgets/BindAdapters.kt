package com.asnk.fdcentral.ui.widgets

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.asnk.fdcentral.ui.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl", "isSmallerImage", requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?, isSmallerImage: Boolean) {
    val builder = Picasso.with(imageView.context)
        .load(url)
        .error(R.drawable.ic_default_food_24)
    if (isSmallerImage) {
        builder.resize(256, 256)
        builder.placeholder(R.drawable.ic_default_food_24)
        builder.centerCrop()
    } else {
        builder.fit()
    }
    builder.into(imageView)
}