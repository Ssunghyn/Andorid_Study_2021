package com.example.retrofit2_study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.retrofit2_study.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    object RetrofitClass{
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://jhi7xevof6.execute-api.ap-northeast-2.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val api = retrofit.create(UrlAPI::class.java)
    }

    val call = RetrofitClass.api.getUrlInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        call.enqueue(object : Callback<UrlInfo>{
            override fun onResponse(call: Call<UrlInfo>, response: Response<UrlInfo>) {
                if (response.isSuccessful) {
                    binding.version.text = response.body()?.body?.get("version").toString()
                    binding.force.text = response.body()?.body?.get("force").toString()
                }
                else call.cancel()
            }

            override fun onFailure(call: Call<UrlInfo>, t: Throwable) {
                call.cancel()
            }
        }
        )
    }

}