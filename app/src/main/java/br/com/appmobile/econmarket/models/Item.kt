package br.com.appmobile.econmarket.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Item(name: String, mark: String, price: Float, quantity: Float, measuringUnit:String, list: List): Serializable {

    @SerializedName("id")
    var id: Long = 0
    @SerializedName("name")
    var name: String = name
    @SerializedName("mark")
    var mark: String = mark
    @SerializedName("price")
    var price: Float = price
    @SerializedName("quantity")
    var quantity: Float = quantity
    @SerializedName("measuringUnit")
    var measuringUnit: String = measuringUnit
    @SerializedName("list")
    var list: List = list
}