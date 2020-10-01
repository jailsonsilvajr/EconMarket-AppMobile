package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.repository.Repository

class LoginViewModel: ViewModel() {

    private val loginUserMutableLiveData: MutableLiveData<User> = MutableLiveData()

    fun observerLoginUser(): LiveData<User> {

        return loginUserMutableLiveData
    }

    fun login(email: String, password: String){

        Repository.getRepository().login(email, password, this.loginUserMutableLiveData)
    }
}