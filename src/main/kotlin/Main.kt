import com.google.gson.Gson
import java.io.File

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

data class Restaurante(
    val name: String,
    val rating: Double,
    val address: Address,
    val itinerary: List<Itinerary>
)

fun main() {
    val jsonFile = File("/Users/vitorlopes/Documents/Biped/Gradle/codelab/src/main/kotlin/dataRestaurants.json")
    val json = jsonFile.readText()

    val restaurante = Gson().fromJson(json, Restaurante::class.java)
    println(restaurante)
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