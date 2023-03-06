package com.asnk.fdcentral.data.model.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.asnk.fdcentral.domain.model.base.Model
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class FoodItemResponse(
    val fdcId: Int,
    val description: String,
    val dataType: String,
    val publicationDate: String,
    val image: String?
): Parcelable , Model()

