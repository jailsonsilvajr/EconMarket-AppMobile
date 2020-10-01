package br.com.appmobile.econmarket.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.network.requestbodys.RequestBodyList
import br.com.appmobile.econmarket.network.requestbodys.RequestBodyUser
import br.com.appmobile.econmarket.network.retrofit2.Retrofit2Instance
import br.com.appmobile.econmarket.network.retrofit2.Retrofit2Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    companion object{

        fun getRepository(): Repository = Repository()
        private fun getService(): Retrofit2Service = Retrofit2Instance.getRetrofit2Instance().create(Retrofit2Service::class.java)
    }

    fun login(email: String, password: String, mutableLiveData: MutableLiveData<User>){

        val call = getService().login(email, password)
        call.enqueue(object : Callback<User> {

            override fun onResponse(call: Call<User>, response: Response<User>) {

                if(response.isSuccessful){

                    mutableLiveData.value = response.body()
                }else{

                    mutableLiveData.value = null
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {


            }
        })
    }

    fun register(name: String, email: String, password: String, mutableLiveData: MutableLiveData<User>){

        val newUser = User(email, password, name)
        val requestBodyPostUser = RequestBodyUser(newUser)
        val call = getService().register(requestBodyPostUser)
        call.enqueue(object : Callback<User>{

            override fun onResponse(call: Call<User>, response: Response<User>) {

                if(response.isSuccessful) mutableLiveData.value = response.body()
                else mutableLiveData.value = null
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

            }
        })
    }

    fun updateUser(user: User, mutableLiveData: MutableLiveData<User>){

        val requestBodyUser = RequestBodyUser(user)
        val call = getService().updateUser(requestBodyUser)
        call.enqueue(object : Callback<User>{

            override fun onResponse(call: Call<User>, response: Response<User>) {

                if(response.isSuccessful) mutableLiveData.value = response.body()
                else mutableLiveData.value = null
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

                Log.d(Repository.toString(), t.message.toString())
            }
        })
    }

    fun addList(name: String, user: User, mutableLiveData: MutableLiveData<List>){

        val newList = List(name)
        val requestBodyPostList = RequestBodyList(newList, user)
        val call = getService().addList(requestBodyPostList)
        call.enqueue(object : Callback<List>{

            override fun onResponse(call: Call<List>, response: Response<List>) {

                if(response.isSuccessful) mutableLiveData.value = response.body()
                else mutableLiveData.value = null
            }

            override fun onFailure(call: Call<List>, t: Throwable) {

            }
        })
    }
}