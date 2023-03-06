package com.asnk.fdcentral.data.model.response

import android.os.Parcelable
import androidx.annotation.Keep
import com.asnk.fdcentral.domain.model.base.Model
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class FoodDetailResponse(
    val fdcId: Int,
    val description: String?,
    val publicationDate: String?,
    val dataType: String,
    val foodClass: String,
    val abstract: String?,
    val title: String?,
    val doiNumber: String?,
    val studyDesign: String?,
    val results: String?,
) : Parcelable, Model()

