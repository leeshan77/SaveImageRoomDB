package com.leeshan77.saveimageroomdb.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImageModel(
    @PrimaryKey(autoGenerate = true)
    var idx: Int?,
    var imageString: String
)
