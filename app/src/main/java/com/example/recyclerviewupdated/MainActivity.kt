package com.example.recyclerviewupdated

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

private const val base_Url="https://api.yelp.com/v3/"
private const val API_KEY="XATl1dLqw97XtEo9vsYz4WjZXmWkVSVRBGGvWHlD1EhGVoeQURaGtcsRRla4M5XAxeaS1cMfV7QTwJIM6vcfNjDVgkzJSWSXNIg0vl_C23iSMTxIQBIauXP9fE04YXYx"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val restarents = mutableListOf<yelprst>()
        val adapter = YelpAdapter(this, restarents);
        rview.layoutManager = LinearLayoutManager(this);
        rview.adapter = adapter


        val retrofit =
            Retrofit.Builder().baseUrl(base_Url).addConverterFactory(GsonConverterFactory.create())
                .build()
        val yelp = retrofit.create(yelpservice::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val resp = yelp.getrequest("Bearer $API_KEY", "Avocado Toast", "New York").body()
            if (resp == null) {
                GlobalScope.launch(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Request Failed", Toast.LENGTH_LONG).show()

                }
            }
            GlobalScope.launch(Dispatchers.Main) {
                resp?.let { restarents.addAll(it?.bs) }
                adapter.notifyDataSetChanged()

            }


        }

    }
}
