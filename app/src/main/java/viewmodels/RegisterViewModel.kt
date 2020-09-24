package viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import models.User

class RegisterViewModel: ViewModel() {

    private val user: MutableLiveData<User> by lazy { MutableLiveData<User>() }

    fun observerUser(): LiveData<User> {

        return this.user
    }

    fun registerUser(email: String, password: String){

        val newUser = User(email, password)
        this.user.value = newUser
    }
}