package br.com.appmobile.econmarket.repository

import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.models.User

class Repository {

    companion object{

        fun getRepository(): Repository = Repository()
    }

    fun login(email: String, password: String): User?{

        val user = User.validateAndCreateUser(email, password)
        //verificar se user é válido
        if(user != null){
            //verificar se email e password estão corretos no database
            //Se ok: return user do database
            return user
        }

        return user
    }

    fun register(email: String, password: String): User?{

        val user = User.validateAndCreateUser(email, password)
        //verificar se user é válido
        if(user != null){
            //criar user no database
            //Se ok: return user do database
            return user
        }
        return user
    }

    fun createAndSaveNewList(name: String): List?{

        val list = List.validateAndCreateList(name)
        //verificar se list é válido
        if(list != null){
            //salvar list no database
            //Se ok: return list do database
            return list
        }
        return list
    }

    fun loadList(): MutableList<List>{

        var lists = mutableListOf<List>()
        for (i in 1..20){

            List.validateAndCreateList("List - $i")?.let { lists.add(it) }
        }
        return lists
    }
}