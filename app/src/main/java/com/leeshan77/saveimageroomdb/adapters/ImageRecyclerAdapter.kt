package com.leeshan77.saveimageroomdb.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leeshan77.saveimageroomdb.databinding.ItemImageBinding
import com.leeshan77.saveimageroomdb.db.ImageModel
import com.leeshan77.saveimageroomdb.utils.BitmapConverter

class ImageRecyclerAdapter : RecyclerView.Adapter<ImageRecyclerAdapter.CustomHolder>() {

    private val imageList = mutableListOf<ImageModel>()
    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHolder {
        mContext = parent.context
        val inflater = LayoutInflater.from(mContext)
        val binding = ItemImageBinding.inflate(inflater, parent, false)
        return CustomHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int = imageList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<ImageModel>) {
        imageList.clear()
        imageList.addAll(list)
        notifyDataSetChanged()
    }

    inner class CustomHolder(private val binding: ItemImageBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(image: ImageModel) {
            binding.apply {
                image.also {
                    txtIdx.text = it.idx.toString()
//                    imageView.setImageBitmap(it.image)

                    val bitmap = BitmapConverter.convertStringToBitmap(it.imageString)
                    imageView.setImageBitmap(bitmap)
                }
            }
        }
    }
}