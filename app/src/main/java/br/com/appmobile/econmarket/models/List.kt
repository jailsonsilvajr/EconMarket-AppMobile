package br.com.appmobile.econmarket.models

class List {

    lateinit var name: String

    companion object{

        fun validateAndCreateList(name: String): List?{

            if(name.isEmpty()) return null
            val newList = List()
            newList.name = name
            return newList
        }
    }
}