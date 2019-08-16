package id.rakaadinugroho.tokolontong.util

import id.rakaadinugroho.tokolontong.R
import id.rakaadinugroho.tokolontong.model.BannerModel
import id.rakaadinugroho.tokolontong.model.CategoryModel
import id.rakaadinugroho.tokolontong.model.ListingModel
import id.rakaadinugroho.tokolontong.model.ProductModel

object GenerateData {
    private fun generateBanner(): BannerModel {
        val listBanner: MutableList<BannerModel.Banner> = mutableListOf()
        listBanner.add(BannerModel().Banner(1, "https://ecs7.tokopedia.net/img/cache/1242/banner/2019/8/6/20723472/20723472_8fa0491b-536a-4d71-81c7-fbed3c7c6188.png"))
        listBanner.add(BannerModel().Banner(2, "https://ecs7.tokopedia.net/img/cache/1242/banner/2019/8/6/20723472/20723472_48a1de0c-fe72-4ef8-a5e1-dc8122232b90.jpg"))
        listBanner.add(BannerModel().Banner(3, "https://ecs7.tokopedia.net/img/cache/1242/banner/2019/8/6/20723472/20723472_84f3b17e-8a9b-4ae0-8f1f-a06627a1a7f9.jpg"))
        return BannerModel(listBanner = listBanner)
    }

    private fun generateCompanyProduct(): ProductModel {
        val listProduct: MutableList<ProductModel.Category> = mutableListOf()
        listProduct.add(ProductModel().Category(10, R.mipmap.ico_one, "Belanja"))
        listProduct.add(ProductModel().Category(12, R.mipmap.ico_two, "Top-Up"))
        listProduct.add(ProductModel().Category(13, R.mipmap.ico_three, "Keuangan"))
        listProduct.add(ProductModel().Category(14, R.mipmap.ico_four, "Tiket"))
        listProduct.add(ProductModel().Category(15, R.mipmap.ico_one, "Emas"))

        return ProductModel(listProduct)
    }

    private fun generateListing(): List<ListingModel> {
        val list: MutableList<ListingModel> = mutableListOf()
        val data = ListingModel(1, 1, "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_d6452363-7d8c-4706-ac84-7f059a7d9a84.jpg", "Kursi Kantor", "Rp 200.000")
        list.add(data)
        list.add(data.copy(idListing = 2, urlThumbnail = "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_c6f70915-577f-4cd4-834c-daf892265ef0.jpg", title = "Batman"))
        list.add(data.copy(idListing = 3, urlThumbnail = "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_c6f70915-577f-4cd4-834c-daf892265ef0.jpg", title = "Vas Bunga Melati"))
        list.add(data.copy(idListing = 4, urlThumbnail = "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_d7c67b76-9ff4-46f9-93a3-ec4be4918439.jpg", title = "Tas Slempang"))

        list.add(data.copy(idListing = 5, idCategory = 2, urlThumbnail = "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_c6f70915-577f-4cd4-834c-daf892265ef0.jpg", title = "Batman"))
        list.add(data.copy(idListing = 6, idCategory = 2, urlThumbnail = "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_d7c67b76-9ff4-46f9-93a3-ec4be4918439.jpg", title = "Batman"))
        list.add(data.copy(idListing = 7, idCategory = 2, urlThumbnail = "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_c6f70915-577f-4cd4-834c-daf892265ef0.jpg", title = "Batman"))
        list.add(data.copy(idListing = 8, idCategory = 2, urlThumbnail = "https://ecs7.tokopedia.net/img/cache/200-square/attachment/2018/8/9/3127195/3127195_d7c67b76-9ff4-46f9-93a3-ec4be4918439.jpg", title = "Batman"))
        
        
        return list
    }

    private fun headerTitleById(idCategory: Int): String = when (idCategory) {
        1 -> "Produk Makanan"
        2 -> "Fashion dan Gaya"
        else -> "Komputer dan Elektronik"
    }

    fun dataGenerator(): MutableList<Any> {
        val list = mutableListOf<Any>()

        list.add(generateBanner())
        list.add(generateCompanyProduct())
        
        val listing = generateListing()
        listing.groupBy { it.idCategory }.forEach {
            list.add(CategoryModel(it.key, headerTitleById(it.key)))
            list.addAll(it.value)
        }

        return list
    }
}