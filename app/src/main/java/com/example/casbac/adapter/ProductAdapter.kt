package com.example.casbac.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide.with
import com.example.casbac.R
import com.example.casbac.model.Product
import com.squareup.picasso.Picasso


class ProductAdapter(private val listProduct: ArrayList<Product>, private val context:Context? ): RecyclerView.Adapter<ProductAdapter.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.title_content)
        var tvDescription: TextView = itemView.findViewById(R.id.description_content)
        var imgImageProduct: ImageView = itemView.findViewById(R.id.image_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_widget,
            parent,
            false
        )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val product = listProduct[position]
        Picasso.get().load(product.image).into(holder.imgImageProduct)
        holder.tvTitle.text = product.name
        holder.tvDescription.text = product.description
    }

    override fun getItemCount(): Int {
        return this.listProduct.size
    }

}