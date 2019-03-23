package tsdev.tech.view.custom

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import tsdev.tech.R

//Glide 조금더 쉽게 사용하기위해서 클래스 만들어 줌
class GlideImageView @JvmOverloads constructor(context: Context,  attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : AppCompatImageView(context, attrs, defStyleAttr) {

    fun loadImage(url: String, @DrawableRes loadingImageRes: Int = R.drawable.ic_bubble_chart_white_24dp) {
        Glide.with(this)
            .load(url)
            .apply( RequestOptions.placeholderOf(loadingImageRes).centerCrop() )
            .into(this)
    }
}