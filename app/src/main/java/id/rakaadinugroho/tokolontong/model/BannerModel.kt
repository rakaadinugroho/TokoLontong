package id.rakaadinugroho.tokolontong.model

import com.idanatz.oneadapter.external.interfaces.Diffable

class BannerModel(val listBanner : List<Banner> = emptyList()) {
    inner class Banner(val id: Int, val urlBanner: String) : Diffable{

        override fun areContentTheSame(other: Any): Boolean = other is BannerModel.Banner && urlBanner == other.urlBanner

        override fun getUniqueIdentifier(): Long = id.toLong()
    }
}