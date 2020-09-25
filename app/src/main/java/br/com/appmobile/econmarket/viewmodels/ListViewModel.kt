package br.com.appmobile.econmarket.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.repository.Repository

class ListViewModel: ViewModel() {

    private val lists: MutableLiveData<MutableList<List>> by lazy { MutableLiveData<MutableList<List>>() }

    fun observerLists(): LiveData<MutableList<List>>{

        return lists
    }

    fun loadArrayList(){

        lists.value = Repository.getRepository().loadLists()
    }
}