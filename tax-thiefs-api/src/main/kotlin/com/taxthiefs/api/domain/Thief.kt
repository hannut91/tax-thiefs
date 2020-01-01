package com.taxthiefs.api.domain

import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.GeoPointField

//{
//    "id":1,
//    "year":2019,
//    "name":"홍영철",
//    "age":46,
//    "shop":"",
//    "job":"예술 스포츠 및 여가관련 서비스업",
//    "address":"서울특별시 강서구 까치산로4길 75-37_화곡동",
//    "total":163299,
//    "taxItem":"부가가치세 등 2",
//    "date":"2017-04-30",
//    "detail":"2013년 부가가치세 등 총 9건 163,299 체납"
//}

@Document(indexName = "thiefs")
class Thief(
        val id: Int = 0,
        val year: Int = 0,
        val name: String = "",
        val age: Int = 0,
        val shop: String = "",
        val job: String = "",
        val address: String = "",
        val total: Int = 0,
        val taxItem: String = "",
        val date: String = "",
        val detail: String = "",
        
        @field:GeoPointField
        val coords: ArrayList<Double> = arrayListOf()
)
