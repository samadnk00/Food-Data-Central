package com.asnk.fdcentral.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.asnk.fdcentral.domain.model.base.ModelEntity
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class FoodDetailEntity(
    val fdcId: Int,
    val description: String?,
    val publicationDate: String?,
    val dataType: String?,
    val foodClass: String?,
    val abstract: String?,
    val title: String?,
    val doiNumber: String?,
    val studyDesign: String?,
    val results: String?,
) : Parcelable, ModelEntity()
