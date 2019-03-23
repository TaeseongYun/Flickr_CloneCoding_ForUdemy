package tsdev.tech.view.main.home.adapter.holder

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_image_view.view.*
import tsdev.tech.R
import tsdev.tech.data.ImageData

class ImageViewHolder(context: Context, parent: ViewGroup?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_view, parent, false)) {

    fun onBind(item: ImageData) {
        itemView.onBind(item)
    }

    private fun View.onBind(item: ImageData) {

        tv_title.text = item.name
        //View 에 있는 context 를 가져옴
//        img_view.setImageResource(resources.getIdentifier(item.fileName, "drawable", context.packageName))
        img_view.loadImage(item.fileName)
    }
}