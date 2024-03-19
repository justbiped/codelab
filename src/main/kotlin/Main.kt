package org.example

import java.io.File

fun main() {
    println("Hello World!")

val restauranteJso= File("/home/wilker/codelab/src/main/restaurante.json").readText()
    println(restauranteJso)


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