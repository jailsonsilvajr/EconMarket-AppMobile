package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.repository.Repository

class ListViewModel: ViewModel() {

    private val newList: MutableLiveData<List> by lazy { MutableLiveData<List>() }
    private val arrayList: MutableLiveData<MutableList<List>> by lazy { MutableLiveData<MutableList<List>>() }

    fun observerNewList(): LiveData<List>{

        return newList
    }

    fun observerArrayList(): LiveData<MutableList<List>>{

        return arrayList
    }

    fun createNewList(name: String){

        newList.value = Repository.getRepository().createAndSaveNewList(name)
    }

    fun loadArrayList(){

        arrayList.value = Repository.getRepository().loadList()
    }
}