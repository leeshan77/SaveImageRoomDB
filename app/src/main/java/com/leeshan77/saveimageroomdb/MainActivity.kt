package com.leeshan77.saveimageroomdb

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.leeshan77.saveimageroomdb.adapters.ImageRecyclerAdapter
import com.leeshan77.saveimageroomdb.databinding.ActivityMainBinding
import com.leeshan77.saveimageroomdb.db.ImageDB
import com.leeshan77.saveimageroomdb.db.ImageModel
import com.leeshan77.saveimageroomdb.db.ImageRepository
import com.leeshan77.saveimageroomdb.utils.BitmapConverter

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val repository: ImageRepository by lazy {
        ImageRepository(ImageDB.getInstance(this).imageDao)
    }

    private val imageRecyclerAdapter: ImageRecyclerAdapter by lazy {
        ImageRecyclerAdapter()
    }

    private val images = listOf(
        R.drawable.cloud,
        R.drawable.park,
        R.drawable.flower,
        R.drawable.hut
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        makeListOfImages()

        binding.recyclerImage.apply {
            adapter = imageRecyclerAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun onResume() {
        super.onResume()

        binding.btnList.setOnClickListener {
            imageRecyclerAdapter.setData(repository.getAllImages())
        }
    }

    private fun makeListOfImages() {
        for (i in 0..1) {
            images.forEach {

                val bitmap = BitmapFactory.decodeResource(resources, it)

                val bitmapString = BitmapConverter.convertBitmapToString(bitmap)

                val item = ImageModel(null, bitmapString)
                repository.insertNewImage(item)
            }
        }
    }
}