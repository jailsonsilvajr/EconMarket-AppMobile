package br.com.appmobile.econmarket.network.requestbodys

import br.com.appmobile.econmarket.models.List
import br.com.appmobile.econmarket.models.User

class RequestBodyUser(user: User) {

    var id: Long = user.id
    var email: String = user.email
    var password: String = user.password
    var name: String = user.name
    var lists: MutableCollection<List> = user.lists
}