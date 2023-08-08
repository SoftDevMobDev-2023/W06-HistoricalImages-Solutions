package au.edu.swin.sdmd.l06_detailedimages_2023

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(val name: String, val author: String,
val latitude: Float, val longitude: Float,
val visited: Boolean = false) : Parcelable
