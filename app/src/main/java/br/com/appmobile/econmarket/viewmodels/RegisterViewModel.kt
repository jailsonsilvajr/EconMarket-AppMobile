package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.repository.Repository

class RegisterViewModel: ViewModel() {

    private val registerUserMutableLiveData: MutableLiveData<User> = MutableLiveData()

    fun observerRegisterUser(): LiveData<User> {

        return this.registerUserMutableLiveData
    }

    fun registerUser(name: String, email: String, password: String){

        Repository.getRepository().register(name, email, password, this.registerUserMutableLiveData)
    }
}