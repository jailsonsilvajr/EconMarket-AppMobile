package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.repository.Repository

class ShowListsViewModel: ViewModel() {

    private val userMutableLiveData: MutableLiveData<User> = MutableLiveData()

    fun observerUser(): LiveData<User>{

        return this.userMutableLiveData
    }

    fun updateUser(user: User){

        Repository.getRepository().updateUser(user, this.userMutableLiveData)
    }
}