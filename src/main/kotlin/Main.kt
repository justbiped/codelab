package org.example

fun main() {
    // Fiz o parse do shape json para o objeto ShapeDto
    val shapeDto = ShapeDto("Unknown", "red", 30.0)
    val mapper = ShapeMapper()
    val shape = mapper.mapToDomain(shapeDto)
    shape.draw()

    val shapes = listOf<Shape>(
        Circle("blue", 10.0),
        Circle("yellow", 13.0),
        Square("black", 100.0),
        Triangle("orange", 20.0),
        Losangle("white", 15.0)
    )

    println()
    println()
    println()
    println()
    shapes.forEach { shape ->
        shape.draw()
    }
}

fun drawShape(shape: Shape) {
    shape.draw()
}

/**
 * Criar uma classe Kotlin representando um objeto restaurante
 * O restaurante contem os seguintes campos
 * Nome
 * Endreço -> é um objecto com os seguintes campos (Rua: Texto, Numero: Texto, CEP: Texto, Cidade : Texto, Estado : Texto, Pais: Texto)
 * Entinerário: É um objeto que vai ter uma lista de working hours
 * Working hours é um objeto com os campos (Dia: Day, Horario Início: String, Horário Fim: String) .. Sobre o dia/ Day, tenta fazer o melhor, mas vamo achar a melhor maneira juntos se precisar
 * Rating (Avaliação) É um campo double de 0 a 5 estrelas
 *
 * NÃO VAMOS INSTANCIAR ESSE OBJETO RESTAURANTE, ou seja, não vamos construir ele na mão, vamos criar um arquivo JSON
 * Esse arquivo vai representar o objeto Restaurante com todos os valores definidos
 *
 * Então eis aqui a tarefa...
 * Ler o arquivo .json
 * Chamar o parser de jSOn para criar o objeto restaurante a partir do arquivo json
 * Imprimir o objeto restaurante -> print(restaurante)
 *
 * O parser de JSON a ser usado é o GSON, sua dependencia deve ser adicionada no arquivo build.gradle.kts... aprenda :sunglass:
 */


DTO - Objeto de transferencia de dados
- ShapeDto

Mapear DTO para o domínio usando um mapper
- Para esse mapeamento, precisamos identificar o tipo do objeto, caso tenhamos uma hierarquia
- No caso do shape, usamos o name
- E se não tivermos algum campo para identificar o tipo?
-- A gente cria o campo tipo
Polimorfismo
- override, sobrescrever o método to tipo genérico
