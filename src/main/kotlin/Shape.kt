package org.example

/**
Open Class
- Pode ser istanciado
- Não pode ter metodos abstratos
-- Todos os métodos são concretos -> fun my function() {}
- Pode ter construtor
- Permite private fields (componentes privados)
- Todos os metodos são final

Abstract Class
- Não pode ser instanciada... não pode new
- Pode ter metodos abstratos, sem implementação, sem corpo
- Pode ter construtor
- Permite private fields (componentes privados)
- IMPLEMENTAÇÃO de metodos normais continuam sendo final
- Os métodos abstratos não podem ter corpo -> { }

Interface
- Não pode ser instanciado
- Não precisa do modificador abstract pra indicar que um método é abstrato
- Mas agora pode ter implementação
- Todos os campos devem ser publicos (Qualquer field é publico)
 **/

/** Final Class não podem ser extendidas **/

/**
 * Temos um conceito chamado DTO
 * Data transfer object
 * - Esses objetos servem apenas e exclusivamente para transferencia de dados, eles não contem
 * nenhuma logica, nenhuma inteligencia
 */

abstract class Shape(open val name: String, val color: String, val area: Double) {
    open fun draw() {
        println(
            "$name - $color - $area"
        )
    }
}

class Square(color: String, area: Double) : Shape("Square", color, area){
    override fun draw() {
       println("O povo de pitangui é o mai bob")
    }
}

class Circle(color: String, area: Double) : Shape("Circle", color, area) {
    override val name: String get() = "Edgar"
}

class Triangle(color: String, area: Double) : Shape("Triangle", color, area)

class Losangle(color: String, area: Double) : Shape("Losangle", color, area) {
    override fun draw() {
        println(
            "$name\n$color\n$area"
        )
    }
}

/**
 * - Alguma resposta do servidor e de acordo com a resposta a gente
 * cria determinado objeto
 * - Pode ser alguma escolha do usuário
 *
 * Shape type pode ser
 * - square
 * - circle
 * - triangle
 *
 * Enum
 * Sealed class - So Kotlin
 **/
fun main() {
    println("Escolha seu shape")
    val shapeType = readlnOrNull()

    when (shapeType) {
        "square" -> Square("blue", 20.00).draw()
        "circle" -> Circle("red", 30.00).draw()
        "triangle" -> Triangle("yellow", 30.00).draw()
        else -> Losangle("white", 10.0).draw()
    }
}