package com.example.recyclerviewupdated

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_res.view.*

class YelpAdapter(val context:Context,val rs:List<yelprst>):RecyclerView.Adapter<YelpAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tvname=view.findViewById<TextView>(R.id.tvName)
        val ratingBar=view.ratingBar
        val tvadress=view.tvadress
        val tvCategory=view.tvCategories
        val tvDist=view.tvDist
        val tvPrice=view.tvPrice
        val img=view.imgview
        val tvRw=view.tvreviews
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
     return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_res,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val res=rs[position]
        holder.tvname.text=res.name
        holder.tvDist.text= res.displayDistance()
        holder.ratingBar.rating=res.rating.toFloat()
        holder.tvadress.text=res.locaiton.adrs
        holder.tvRw.text="${res.rw} reviews"
        holder.tvPrice.text=res.price
        holder.tvCategory.text=res.ct[0].title
        Glide.with(context).load(res.img).apply(RequestOptions().transform(
            CenterCrop(),RoundedCorners(20)
        )).into(holder.img)

    }

    override fun getItemCount(): Int=rs.size


}