package com.asnk.fdcentral.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class FoodEntry(
    val fdcId: Int,
    val description: String,
    val dataType: String,
    val publicationDate: String,
    val image: String
): Parcelable
