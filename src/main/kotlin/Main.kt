package org.example

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

val gson = Gson()

fun main() {
    val restaurantJson = File("restaurants.json").readText()

    val listType = object : TypeToken<List<Restaurant>>() {}.type
    val restaurants: List<Restaurant> = gson.fromJson(restaurantJson, listType)
}

/** No momento temos apenas uma lista de restaurantes... Mas devemos dar suporte a cafeterias
 * --- Quick info .. Todoo objeto em java e kotlin possuem o método toString()
 *
 * Ao dar print num restaurante, ele deve apresentar seus dados no seguinte formato
 * Nome
 * Endereço em linha
 * Rating
 *
 * Ao dar print numa cafeteria, devemos apresentar seus dados no seguinte formato
 * Nome
 * Rating
 * Endereço em linha
 *
 * Proibido usar if e else para o print, fica a dica :sunglass:
 *
 * Crie uma função customizada para receber restaurantes e cafeterias e imprimi-los, exemplo, prettyPrint :)
 *
 * Dica: Polimorfismo
**/