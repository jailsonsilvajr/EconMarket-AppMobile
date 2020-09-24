package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.repository.Repository

class RegisterViewModel: ViewModel() {

    private val user: MutableLiveData<User> by lazy { MutableLiveData<User>() }

    fun observerUser(): LiveData<User> {

        return this.user
    }

    fun registerUser(email: String, password: String){

        this.user.value = Repository.getRepository().register(email, password)
    }
}