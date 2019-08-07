package id.rakaadinugroho.tokolontong.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import id.rakaadinugroho.tokolontong.model.BannerModel
import id.rakaadinugroho.tokolontong.ui.ItemBannerFragment

class BannerAdapter(fm: androidx.fragment.app.FragmentManager, private val banners: List<BannerModel.Banner>) : androidx.fragment.app.FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return ItemBannerFragment.newInstance(banners[position].urlBanner)
    }

    override fun getCount(): Int = banners.size
}