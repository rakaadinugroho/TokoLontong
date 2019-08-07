package id.rakaadinugroho.tokolontong.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import id.rakaadinugroho.tokolontong.R
import kotlinx.android.synthetic.main.item_banner.*

class ItemBannerFragment: androidx.fragment.app.Fragment() {
    companion object {
        fun newInstance(urlBanner: String): ItemBannerFragment = ItemBannerFragment().apply {
            val args = Bundle()
            args.putString("url", urlBanner)
            arguments = args
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.item_banner, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val urlBanner = arguments?.getString("url")

        urlBanner.let {
            Picasso.get().load(it).into(item_banner_thumbnail)
        }
    }
}