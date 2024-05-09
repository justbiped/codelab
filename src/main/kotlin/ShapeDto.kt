package org.example

class ShapeDto(
    val name: String,
    val color: String,
    val area: Double
)

class ShapeMapper(){
    fun mapToDomain(shapeDto: ShapeDto) : Shape {
        return when(shapeDto.name) {
            "Square" -> Square(shapeDto.color, shapeDto.area)
            "Circle" -> Circle(shapeDto.color, shapeDto.area)
            "Triangle" -> Triangle(shapeDto.color, shapeDto.area)
            else -> Losangle(shapeDto.color, shapeDto.area)
        }
    }
}