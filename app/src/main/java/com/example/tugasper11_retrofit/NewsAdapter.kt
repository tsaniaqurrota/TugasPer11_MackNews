package com.example.tugasper11_retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.example.tugasper11_retrofit.databinding.ItemNewsBinding
import com.example.tugasper11_retrofit.model.Data

class NewsAdapter(private val listsNews: List<Data>) :
    RecyclerView.Adapter<NewsAdapter.ItemNewsViewHolder>() {

    inner class ItemNewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Data) {
            with(binding) {
                titleTxt.text = data.title
                authorTxt.text = data.author
                publishTxt.text = data.time
                descTxt.text = data.desc

                Glide.with(itemView.context).asBitmap().load(data.thumb)
                    .transition(BitmapTransitionOptions.withCrossFade())
                    .into(newsThumb)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ItemNewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemNewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listsNews.size
    }

    override fun onBindViewHolder(holder: ItemNewsViewHolder, position: Int) {
        holder.bind(listsNews[position])
    }
}
