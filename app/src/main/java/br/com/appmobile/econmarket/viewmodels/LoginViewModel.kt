package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.repository.Repository

class LoginViewModel: ViewModel() {

    private val user: MutableLiveData<User> by lazy {

        MutableLiveData<User>()
    }

    fun getUser(): LiveData<User> {

        return user
    }

    fun loadUser(email: String, password: String){

        this.user.value = Repository.getRepository().login(email, password)
    }
}