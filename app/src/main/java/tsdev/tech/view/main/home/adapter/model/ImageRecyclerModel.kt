package tsdev.tech.view.main.home.adapter.model


import tsdev.tech.data.Photo

interface ImageRecyclerModel {

    fun addItem(imageData: Photo)

    fun getItemCount(): Int

    fun notifyDataSetChang()
}