package hasan.gurgur.covid_19.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import hasan.gurgur.covid_19.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImageFromUrl(imageview: ImageView, url : String?) {
        Glide.with(imageview.context).load("https://countryflagsapi.com/png/$url").placeholder(R.drawable.placeholder).into(imageview)
    }



}