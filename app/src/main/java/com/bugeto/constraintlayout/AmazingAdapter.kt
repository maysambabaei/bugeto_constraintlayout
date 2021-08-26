package com.bugeto.constraintlayout

import android.content.Context
import android.graphics.Paint
import android.os.Build
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AmazingAdapter(
    private var context: Context,
    private var amazingItem: ArrayList<AmazingModel>
) :
    RecyclerView.Adapter<AmazingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.amazing_item, parent, false)
        )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = amazingItem[position]
        if (position == 0) {
            holder.lyFirst.visibility = View.VISIBLE
        } else {
            holder.lyFirst.visibility = View.GONE
        }

        if (position == amazingItem.size - 1) {
            holder.lySecound.visibility = View.VISIBLE
        } else {
            holder.lySecound.visibility = View.GONE
        }


        Picasso.get().load(data.image).transform(CircleTransform()).into(holder.ivProduct)
        holder.tvName.text = data.productName
        holder.tvPrice.text = data.price
        holder.tvFirstPrice.text = data.firstPrice
        holder.tvFirstPrice.paintFlags =
            holder.tvFirstPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        holder.tvDiscount.text = data.discount
        holder.chronometer.isCountDown = true
        holder.chronometer.base = SystemClock.elapsedRealtime() + data.time * 3600000
        holder.chronometer.start()
    }

    override fun getItemCount(): Int {
        return amazingItem.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivProduct: AppCompatImageView = itemView.findViewById(R.id.iv_product)
        var tvName: AppCompatTextView = itemView.findViewById(R.id.tv_productName)
        var tvDiscount: AppCompatTextView = itemView.findViewById(R.id.tv_discount)
        var tvPrice: AppCompatTextView = itemView.findViewById(R.id.tv_price)
        var tvFirstPrice: AppCompatTextView = itemView.findViewById(R.id.tv_firstPrice)
        var lyFirst: ConstraintLayout = itemView.findViewById(R.id.cv_first)
        var lySecound: ConstraintLayout = itemView.findViewById(R.id.ly_secound)
        var chronometer: Chronometer = itemView.findViewById(R.id.view_timer)
    }


}