package viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.User
import repository.Repository

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