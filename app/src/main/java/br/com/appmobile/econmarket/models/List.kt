package br.com.appmobile.econmarket.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class List(name: String): Serializable {

    @SerializedName("id")
    var id: Long = 0
    @SerializedName("name")
    var name: String = name
    @SerializedName("items")
    var items = mutableListOf<Item>()
}