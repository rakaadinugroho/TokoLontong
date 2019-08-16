package id.rakaadinugroho.tokolontong.model

import com.idanatz.oneadapter.external.interfaces.Diffable

class ProductModel(val listCategory : List<Category> = emptyList()) {
    inner class Category (val id: Int, val iconSource: Int, val title: String): Diffable {
        override fun areContentTheSame(other: Any): Boolean = other is Category && id == other.id

        override fun getUniqueIdentifier(): Long = id.toLong()

    }
}