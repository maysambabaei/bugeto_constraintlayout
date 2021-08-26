package com.bugeto.constraintlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CategoryAdapter(
    private var context: Context,
    private var sliderItem: ArrayList<CategoryModel>
) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.image_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var data = sliderItem[position]
        Picasso.get().load(data.image).transform(CircleTransform()).into(holder.ivCategory)
        holder.tvName.text=data.name
    }

    override fun getItemCount(): Int {
        return sliderItem.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivCategory: AppCompatImageView = itemView.findViewById(R.id.iv_category)
        var tvName: AppCompatTextView = itemView.findViewById(R.id.tv_name)
    }


}