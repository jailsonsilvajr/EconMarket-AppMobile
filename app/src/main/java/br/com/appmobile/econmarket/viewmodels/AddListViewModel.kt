package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.repository.Repository

class AddListViewModel: ViewModel() {

    private val newList: MutableLiveData<List> by lazy { MutableLiveData<List>() }

    fun observerNewList(): LiveData<List>{

        return this.newList
    }

    fun addNewList(name: String){

        this.newList.value = Repository.getRepository().createAndSaveNewList(name)
    }
}