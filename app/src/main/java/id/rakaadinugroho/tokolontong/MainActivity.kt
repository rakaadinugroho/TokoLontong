package id.rakaadinugroho.tokolontong

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.idanatz.oneadapter.OneAdapter
import com.idanatz.oneadapter.external.modules.ItemModule
import com.idanatz.oneadapter.external.modules.ItemModuleConfig
import com.idanatz.oneadapter.internal.holders.ViewBinder
import com.pixelcan.inkpageindicator.InkPageIndicator
import com.squareup.picasso.Picasso
import id.rakaadinugroho.tokolontong.adapter.BannerAdapter
import id.rakaadinugroho.tokolontong.adapter.CategoryAdapter
import id.rakaadinugroho.tokolontong.model.BannerModel
import id.rakaadinugroho.tokolontong.model.CategoryModel
import id.rakaadinugroho.tokolontong.model.ListingModel
import id.rakaadinugroho.tokolontong.model.ProductModel
import id.rakaadinugroho.tokolontong.util.GenerateData
import id.rakaadinugroho.tokolontong.util.ExpandingViewPagerTransforming
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: OneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        dashboard_content.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        }

        mainAdapter = OneAdapter()
            .attachItemModule(BannerModule())
            .attachItemModule(CategoryModule())
            .attachItemModule(HeaderCategoryModule())
            .attachItemModule(ListingModule())
            .attachTo(dashboard_content)

        mainAdapter.setItems(GenerateData.dataGenerator())

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun BannerModule() = object : ItemModule<BannerModel>() {
        override fun onBind(model: BannerModel, viewBinder: ViewBinder) {
            val adapter = BannerAdapter(supportFragmentManager, model.listBanner)
            val bannerList = viewBinder.findViewById<ViewPager>(R.id.banner_list)
            val bannerMore = viewBinder.findViewById<TextView>(R.id.banner_more)
            val bannerIndicator = viewBinder.findViewById<InkPageIndicator>(R.id.banner_indicator)
            bannerList.apply {
                this.adapter = adapter
                setPadding(32, 0, 32, 0)
                setPageTransformer(true, ExpandingViewPagerTransforming())
            }
            bannerIndicator.setViewPager(bannerList)
            bannerMore.setOnClickListener {
                Toast.makeText(this@MainActivity, "More", Toast.LENGTH_SHORT).show()
            }
        }

        override fun provideModuleConfig(): ItemModuleConfig = object : ItemModuleConfig() {
            override fun withLayoutResource(): Int = R.layout.section_banner
        }
    }

    private fun CategoryModule() = object : ItemModule<ProductModel>() {
        override fun onBind(model: ProductModel, viewBinder: ViewBinder) {
            val adapter = CategoryAdapter(model.listCategory)
            viewBinder.findViewById<RecyclerView>(R.id.content_category).apply {
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
                this.adapter = adapter
            }
        }

        override fun provideModuleConfig(): ItemModuleConfig = object : ItemModuleConfig() {
            override fun withLayoutResource(): Int = R.layout.section_category
        }
    }

    private fun ListingModule() = object : ItemModule<ListingModel>() {
        override fun onBind(model: ListingModel, viewBinder: ViewBinder) {
            val thumb = viewBinder.findViewById<ImageView>(R.id.content_listing_thumb)
            val title = viewBinder.findViewById<TextView>(R.id.content_listing_title)
            val price = viewBinder.findViewById<TextView>(R.id.content_listing_price)

            Picasso.get().load(model.urlThumbnail).into(thumb)
            title.text = model.title
            price.text = model.price
        }

        override fun provideModuleConfig() = object : ItemModuleConfig() {
            override fun withLayoutResource() = R.layout.section_content_listing
        }

    }

    private fun HeaderCategoryModule() = object : ItemModule<CategoryModel>() {
        override fun onBind(model: CategoryModel, viewBinder: ViewBinder) {
            val title = viewBinder.findViewById<TextView>(R.id.header_listing_title)
            title.text = model.titleCategory
        }

        override fun provideModuleConfig(): ItemModuleConfig  = object : ItemModuleConfig() {
            override fun withLayoutResource(): Int = R.layout.section_header_listing
        }

    }

}
