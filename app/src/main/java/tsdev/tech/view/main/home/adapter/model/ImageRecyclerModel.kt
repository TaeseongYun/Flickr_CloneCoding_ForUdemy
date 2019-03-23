package tsdev.tech.view.main.home.adapter.model

import tsdev.tech.data.ImageData

interface ImageRecyclerModel {

    fun addItem(imageData: ImageData)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}