package com.example.newlibrary.ui.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize
data class UICharacter(
    val id: Int,
    val name: String,
    val imageUrl: String
) : Parcelable



