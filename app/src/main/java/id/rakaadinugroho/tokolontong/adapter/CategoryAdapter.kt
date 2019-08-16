package id.rakaadinugroho.tokolontong.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import id.rakaadinugroho.tokolontong.R
import id.rakaadinugroho.tokolontong.model.ProductModel

class CategoryAdapter(val list: List<ProductModel.Category>): RecyclerView.Adapter<CategoryAdapter.CategoryVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryVH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        holder.bind(list[position])
    }

    inner class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumb = itemView.findViewById<ImageView>(R.id.item_category_thumb)
        val label = itemView.findViewById<TextView>(R.id.item_category_label)
        fun bind(data: ProductModel.Category) {
            Picasso.get().load(data.iconSource).into(thumb)
            label.text = data.title
        }
    }
}