package br.com.appmobile.econmarket.network.retrofit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2Instance {

    companion object{

        private const val baseUrl = "http://192.168.0.105:8080/"

        fun getRetrofit2Instance(): Retrofit{

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}