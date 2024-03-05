package com.app.tugasirgifahrezy

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items (
    val name: String,
    val harga: Int
): Parcelable