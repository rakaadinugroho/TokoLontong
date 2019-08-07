package id.rakaadinugroho.tokolontong

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.idanatz.oneadapter.OneAdapter
import com.idanatz.oneadapter.external.modules.ItemModule
import com.idanatz.oneadapter.external.modules.ItemModuleConfig
import com.idanatz.oneadapter.internal.holders.ViewBinder
import com.pixelcan.inkpageindicator.InkPageIndicator
import id.rakaadinugroho.tokolontong.adapter.BannerAdapter
import id.rakaadinugroho.tokolontong.model.BannerModel
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
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        mainAdapter = OneAdapter()
            .attachItemModule(BannerModule())
            .attachTo(dashboard_content)

        mainAdapter.setItems(listOf(GenerateData.generateBanner()))
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
}
