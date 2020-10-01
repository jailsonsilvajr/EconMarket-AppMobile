package br.com.appmobile.econmarket.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User(email: String, password: String, name: String): Serializable{

    @SerializedName("id")
    var id: Long = 0

    @SerializedName("email")
    var email: String = email

    @SerializedName("password")
    var password: String = password

    @SerializedName("name")
    var name: String = name

    @SerializedName("lists")
    var lists = mutableListOf<List>()

    companion object{

        fun getCopy(user: User): User{

            val userCopy = User(user.email, user.password, user.name)
            userCopy.id = user.id
            userCopy.lists = user.lists
            return userCopy
        }
    }
}