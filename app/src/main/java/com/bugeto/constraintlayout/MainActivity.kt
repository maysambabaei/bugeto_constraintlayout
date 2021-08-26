package com.bugeto.constraintlayout

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.custom.sliderimage.logic.SliderImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val duration = 60
    val pixelsToMove = 30
    val mHandler = Handler(Looper.getMainLooper())
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: CategoryAdapter
    lateinit var amazingAdapter: AmazingAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sliderItem =
            listOf(
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/00cc62492b0d1b394b81bcc9d553b6a55a8f9a8c_1597562153.jpg?x-oss-process=image/quality,q_80",
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/410a4c9f5ffe738c5344710c1ef3f88a9f7c8525_1599473226.jpg?x-oss-process=image/quality,q_80",
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/2da09d3a4794844b90cbcadd71ceff18b31d0c80_1599284411.jpg?x-oss-process=image/quality,q_80",
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/e92467d815a70e7503b7b5df8dee00b3c43c42e7_1599661206.jpg?x-oss-process=image/quality,q_80",
                "https://dkstatics-public.digikala.com/digikala-adservice-banners/154818e0409385c221c8fc549776349fce45d5b1_1599285943.jpg?x-oss-process=image/quality,q_80"
            )


        // Create slider image component
        val sliderImage = SliderImage(this)
        // Add image URLs to sliderImage
        slider.setItems(sliderItem)
        slider.addTimerToSlide(2000)
        categoryRecycler()
        amazingRecycler()
        grid1Init()
    }

    fun categoryRecycler() {
        var category = ArrayList<CategoryModel>()
        category.add(
            CategoryModel(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSVhthM6uHYB0IZLvPOk10U3Jfu-Exd8osvHQ&usqp=CAU",
                "دسته بندی 1"
            )
        )
        category.add(
            CategoryModel(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSM6ZNFuopAo-j0A3NDQV3lv87m7_z5RQN7PA&usqp=CAU",
                "دسته بندی 2"
            )
        )
        category.add(
            CategoryModel(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRTOjIYQP0jAthg12O6CPe_CkixNZ8lzlw4Vw&usqp=CAU",
                "دسته بندی 3"
            )
        )
        category.add(
            CategoryModel(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQMkBvEtgonb9iSIZDMMh90Z0pGdUTe0p3Pzg&usqp=CAU",
                "دسته بندی 4"
            )
        )
        category.add(
            CategoryModel(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTu3t1GNUhdz7yc5eWSnLoOP5Xst0ENW2gwcQ&usqp=CAU",
                "دسته بندی 5"
            )
        )
        adapter = CategoryAdapter(this, category)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_category.layoutManager = layoutManager
        rv_category.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    fun amazingRecycler() {
        var amazing = ArrayList<AmazingModel>()
        amazing.add(
            AmazingModel(
                "https://dkstatics-public.digikala.com/digikala-products/119595523.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350/quality,q_60",
                "ست کتری و قوری پونته مدل Metal",
                "44 %",
                "366.000",
                "650.000",
                15
            )

        )

        amazing.add(
            AmazingModel(
                "https://dkstatics-public.digikala.com/digikala-products/5f0e30e3d78621ae59816ce8d9964f443270b66c_1594800585.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350/quality,q_60",
                "عینک آفتابی ری بن مدل 3025S 000133 55",
                "38 %",
                "2.335.000",
                "3.750.700",
                9
            )

        )


        amazing.add(
            AmazingModel(
                "https://dkstatics-public.digikala.com/digikala-products/113919238.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350/quality,q_60",
                "رومیزی ترمه مدل میخک کد SRMH1-1CH",
                "60 %",
                "59.000",
                "147.000",
                10
            )

        )

        amazing.add(
            AmazingModel(
                "https://dkstatics-public.digikala.com/digikala-products/0a9a44e998cb3a048aed4777a5e202e307fed645_1600713505.jpg?x-oss-process=image/resize,m_lfit,h_350,w_350/quality,q_60",
                "نیم بوت مردانه رخشی مدل 7838",
                "27 %",
                "249.000",
                "339.000",
                11
            )

        )

        amazingAdapter = AmazingAdapter(this, amazing)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_amazing.layoutManager = layoutManager
        rv_amazing.adapter = amazingAdapter
        amazingAdapter.notifyDataSetChanged()
    }

    fun grid1Init(){
        Picasso.get().load("https://dkstatics-public.digikala.com/digikala-adservice-banners/609fb9a7d217bc9d049f2204361a65289c8f42bb_1600883942.jpg?x-oss-process=image/quality,q_80").into(grid1_ivOne)
        Picasso.get().load("https://dkstatics-public.digikala.com/digikala-adservice-banners/c9c2a64f835ebee94d581b647962d432130af4b6_1600883703.jpg?x-oss-process=image/quality,q_80").into(grid1_ivTowo)
        Picasso.get().load("https://dkstatics-public.digikala.com/digikala-adservice-banners/4e8173a6e7b8f1a515d59914c70639fd4f41de3f_1601196689.jpg?x-oss-process=image/quality,q_80").into(grid1_ivThree)
        Picasso.get().load("https://dkstatics-public.digikala.com/digikala-adservice-banners/eb58c3511c71ecb2e2cad53e4c4fd8c5325f796c_1601102918.jpg?x-oss-process=image/quality,q_80").into(grid1_ivFour)
    }

}








