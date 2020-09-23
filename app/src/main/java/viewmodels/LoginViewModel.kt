package viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.User

class LoginViewModel: ViewModel() {

    private val user: MutableLiveData<User> by lazy {

        MutableLiveData<User>()
    }

    fun getUser(): LiveData<User> {

        return user
    }

    fun loadUser(email: String, password: String){

        var userTemp = User("user@gmail.com", "123456")

        if(email.equals(userTemp.email) && password.equals(userTemp.password))
            user.value = userTemp
        else
            user.value = null
    }
}