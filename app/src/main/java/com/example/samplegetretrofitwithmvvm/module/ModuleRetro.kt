package com.example.samplegetretrofitwithmvvm.module

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModuleRetro(
    var userId: Int = 0,
    var id: Int = 0,
    var title: String = "",
    var body: String = ""
): Parcelable
