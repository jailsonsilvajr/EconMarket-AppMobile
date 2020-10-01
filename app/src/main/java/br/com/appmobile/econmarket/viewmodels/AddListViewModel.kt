package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.models.User
import br.com.appmobile.econmarket.repository.Repository

class AddListViewModel: ViewModel() {

    private val addListMutableLiveData: MutableLiveData<List> = MutableLiveData()

    fun observerAddList(): LiveData<List>{

        return this.addListMutableLiveData
    }

    fun addList(name: String, user: User){

        Repository.getRepository().addList(name, user, addListMutableLiveData)
    }
}