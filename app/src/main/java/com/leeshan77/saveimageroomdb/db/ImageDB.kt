package com.leeshan77.saveimageroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [ImageModel::class], version = 1)
abstract class ImageDB : RoomDatabase() {

    abstract val imageDao: ImageDao

    companion object {
        private var INSTANCE: ImageDB? = null

        fun getInstance(context: Context): ImageDB {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    ImageDB::class.java,
                    "image_db_112"
                ).build()
            }

            return INSTANCE as ImageDB
        }

    }

}