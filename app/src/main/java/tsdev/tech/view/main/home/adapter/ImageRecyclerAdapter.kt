package tsdev.tech.view.main.home.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tsdev.tech.data.ImageData
import tsdev.tech.view.main.home.adapter.holder.ImageViewHolder
import tsdev.tech.view.main.home.adapter.model.ImageRecyclerModel

class ImageRecyclerAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(),
    ImageRecyclerModel {

    private val list = mutableListOf<ImageData>()

    override fun addItem(imageData: ImageData) {
        list.add(imageData)
    }

    override fun notifyDataSetChang() {
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ImageViewHolder(context, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as? ImageViewHolder)?.onBind(list[position])
    }

}