package repository

import models.User

class Repository {

    companion object{

        fun getRepository(): Repository = Repository()
    }

    fun login(email: String, password: String): User{

        return User(email, password)
    }

    fun register(email: String, password: String): User{

        return User(email, password)
    }
}