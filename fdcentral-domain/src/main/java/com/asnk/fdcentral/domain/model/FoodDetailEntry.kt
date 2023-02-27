package com.asnk.fdcentral.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class FoodDetailEntry(
    val fdcId: Int,
    val description: String,
    val publicationDate: String,
    val dataType: String,
    val foodClass: String,
    val abstract: String,
    val title: String,
    val doiNumber: String,
    val studyDesign: String,
    val results: String,
) : Parcelable
