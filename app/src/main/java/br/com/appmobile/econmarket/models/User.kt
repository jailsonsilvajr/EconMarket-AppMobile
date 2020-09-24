package br.com.appmobile.econmarket.models

class User{

    lateinit var email: String
    lateinit var password: String

    companion object{

        fun validateAndCreateUser(email: String, password: String): User?{

            if(email.isEmpty() || password.isEmpty()){

                return null
            }else{

                val newUser = User()
                newUser.email = email
                newUser.password = password
                return newUser
            }
        }
    }
}