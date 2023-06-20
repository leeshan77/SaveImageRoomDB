package com.leeshan77.saveimageroomdb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDao {

    @Query("select * from ImageModel")
    suspend fun getAllImages(): List<ImageModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewImage(image: ImageModel)

}