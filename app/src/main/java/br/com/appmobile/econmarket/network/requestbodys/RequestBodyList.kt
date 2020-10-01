package br.com.appmobile.econmarket.network.requestbodys

import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.models.User

class RequestBodyList(list: List, user: User) {

    var id = list.id
    var name: String = list.name
    var users = mutableListOf<User>(user)
    var items = list.items
}