package id.rakaadinugroho.tokolontong.model

import com.idanatz.oneadapter.external.interfaces.Diffable

data class ListingModel(val idListing:Long, val idCategory: Int, val urlThumbnail: String, val title: String, val price: String) :Diffable{
    override fun areContentTheSame(other: Any): Boolean {
        return (other is ListingModel) && other.idListing == idListing
    }

    override fun getUniqueIdentifier(): Long {
        return idListing
    }
}