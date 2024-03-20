package org.example
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File


val gson = Gson()

open class CommercialPlace(
    val name: String,
    val address: String,
    val rating: Double
)
class CoffeeShop(
    name: String,
    address: String,
    rating: Double
) : CommercialPlace(name, address, rating)

class Restaurants(
    name: String,
    address: String,
    rating: Double,
    val itinerary: List<Itinerary>
) : CommercialPlace(name, address, rating)
data class Address(
    val street: String,
    val number: String,
    val cep: String,
    val city: String,
    val state: String,
    val country: String
)

data class Itinerary(
    val day: String,
    val startTime: String,
    val endTime: String
)
fun prettyPrint(commercialPlace: List<CommercialPlace>) {
    commercialPlace.forEach { commercialPlace ->
        println("Name: ${commercialPlace.name}")
        println("Address: ${commercialPlace.address}")
        println("Rating: ${commercialPlace.rating}")

        when (commercialPlace) {
            is CoffeeShop -> println("Name: ${commercialPlace.name}, Rating: ${commercialPlace.rating}, Address: ${commercialPlace.address}")
            is Restaurants -> println("Name: ${commercialPlace.name}, Address: ${commercialPlace.address} Rating: ${commercialPlace.rating},")
        }

        println()
    }
}

fun main() {
    val jsonFile = File("src\\main\\kotlin\\dataRestaurants.json")
    val json = jsonFile.readText()
    //val listType = object : TypeToken<List<CommercialPlace>>() {}.type
    //val commercialPlace: List<CommercialPlace> = gson.fromJson(json, listType)
    val commercialPlace: List<CommercialPlace> = Gson().fromJson(json, Array<CommercialPlace>::class.java).toList()

    prettyPrint(commercialPlace)
}






