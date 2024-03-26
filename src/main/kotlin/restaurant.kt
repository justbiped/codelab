
package org.example
class Restaurant

fun main() {
    class Restaurant(
        var name: String,
        var rating: Double
    )
    class Adress(
        var country: String,
        var city: String,
        var road: String,
        var number: String,
        var neighborhood: String,
        var state: String
    )
    class WorkingHours(
        var day: String,
        var start_Hourts: String,
        var end_Hours: String,
        )
    class Itinerary(
        var workingHours: List<WorkingHours>
    )
}



