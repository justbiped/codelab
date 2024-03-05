package org.example

data class Restaurant(
    val name: String,
    val rating: Double,
    val address: Address,
    val itinerary: List<Itinerary>
)

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
