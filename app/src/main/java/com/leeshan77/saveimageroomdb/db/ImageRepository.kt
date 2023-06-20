package com.leeshan77.saveimageroomdb.db

import kotlinx.coroutines.runBlocking

class ImageRepository(private val imageDao: ImageDao) {

    fun getAllImages(): List<ImageModel> = runBlocking {
        imageDao.getAllImages()
    }

    fun insertNewImage(image: ImageModel) = runBlocking {
        imageDao.insertNewImage(image)
    }

}