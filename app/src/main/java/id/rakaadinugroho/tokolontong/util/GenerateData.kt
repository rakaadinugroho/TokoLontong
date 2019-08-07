package id.rakaadinugroho.tokolontong.util

import id.rakaadinugroho.tokolontong.model.BannerModel

object GenerateData {
    fun generateBanner(): BannerModel {
        val listBanner: MutableList<BannerModel.Banner> = mutableListOf()
        listBanner.add(BannerModel().Banner(1, "https://ecs7.tokopedia.net/img/cache/1242/banner/2019/8/6/20723472/20723472_8fa0491b-536a-4d71-81c7-fbed3c7c6188.png"))
        listBanner.add(BannerModel().Banner(2, "https://ecs7.tokopedia.net/img/cache/1242/banner/2019/8/6/20723472/20723472_48a1de0c-fe72-4ef8-a5e1-dc8122232b90.jpg"))
        listBanner.add(BannerModel().Banner(3, "https://ecs7.tokopedia.net/img/cache/1242/banner/2019/8/6/20723472/20723472_84f3b17e-8a9b-4ae0-8f1f-a06627a1a7f9.jpg"))
        return BannerModel(listBanner = listBanner)
    }
}