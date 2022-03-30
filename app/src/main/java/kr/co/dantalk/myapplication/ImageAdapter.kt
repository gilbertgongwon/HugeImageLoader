package kr.co.dantalk.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.dantalk.myapplication.databinding.ItemImageBinding

class ImageAdapter : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    val data: ArrayList<String> = ArrayList()
    fun setData(arrayList: ArrayList<String>) {
        data.clear()
        data.addAll(arrayList)
        notifyItemRangeInserted(0, data.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String) {
            Glide.with(binding.root).load(s).into(binding.imageView)
        }
    }
}