package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.repository.Repository

class ListViewModel: ViewModel() {

    private val newList: MutableLiveData<List> by lazy { MutableLiveData<List>() }
    private val arrayList: MutableLiveData<kotlin.collections.List<List>> by lazy { MutableLiveData<kotlin.collections.List<List>>() }

    fun observerNewList(): LiveData<List>{

        return newList
    }

    fun observerArrayList(): LiveData<kotlin.collections.List<List>>{

        return arrayList
    }

    fun createNewList(name: String){

        newList.value = Repository.getRepository().createAndSaveNewList(name)
    }

    fun loadArrayList(){

        
    }
}