package com.example.recyclerviewupdated

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

public interface yelpservice {
    @GET("businesses/search")
   suspend fun getrequest(
        @Header("Authorization") authHeader:String,
        @Query("term") search:String,
        @Query("location") location:String): Response<Yelpsearch>
}