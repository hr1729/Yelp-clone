package com.example.recyclerviewupdated

import com.google.gson.annotations.SerializedName

data class Yelpsearch(
    @SerializedName("total") val total:String,
    @SerializedName("businesses") val bs:List<yelprst>
)
data class yelprst(
    val name:String,
    val rating:Double,
    val price:String,
    @SerializedName("review_count") val rw:String,
    @SerializedName("distance") val dist:Double,
    @SerializedName("image_url") val img:String,
    @SerializedName("categories") val ct:List<yelpCategory>,
    @SerializedName("location") val locaiton:yelpLocation
){
    fun displayDistance():String{
        val miles=0.000621371
        val distance="%.2f".format(dist*miles)
        return "$distance mil"
    }
}
data class yelpCategory(
    val title:String
)
data class yelpLocation(
    @SerializedName("address1") val adrs:String
)
