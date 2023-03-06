package com.asnk.fdcentral.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.asnk.fdcentral.domain.model.base.ModelEntity
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class FoodItemEntity(
    val fdcId: Int,
    val description: String,
    val dataType: String,
    val publicationDate: String,
    val image: String?
): Parcelable, ModelEntity()
