package br.com.appmobile.econmarket.network.retrofit2

import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.network.requestbodys.RequestBodyList
import br.com.appmobile.econmarket.network.requestbodys.RequestBodyUser
import retrofit2.Call
import retrofit2.http.*

interface Retrofit2Service {

    @GET("user/login")
    fun login(@Query("email") email: String, @Query("password") password: String): Call<User>

    @POST("user/register")
    fun register(@Body requestBodyUser: RequestBodyUser): Call<User>

    @PUT("user/update")
    fun updateUser(@Body requestBodyUser: RequestBodyUser): Call<User>

    @POST("list")
    fun addList(@Body requestBodyList: RequestBodyList): Call<List>

    @PUT("list")
    fun updateList(@Body requestBodyList: RequestBodyList): Call<List>
}