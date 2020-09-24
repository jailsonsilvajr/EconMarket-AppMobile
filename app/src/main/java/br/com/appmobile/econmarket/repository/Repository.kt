package br.com.appmobile.econmarket.repository

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
}