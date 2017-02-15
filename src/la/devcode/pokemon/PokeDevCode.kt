package la.devcode.pokemon

import java.util.*

/**
 * Created by DEMG on 15/02/2017.
 */
enum class Pokemones(val id: Int) {
    BULBASAUR(1), CHARMANDER(2), SQUIRTLE(3), PIKACHU(4)
}

fun main(args: Array<String>) {
    println("Elige un pokemón")
    for ((index, p) in Pokemones.values().withIndex()) {
        println("${index + 1} $p")
    }

    val scanner = Scanner(System.`in`)
    val opcion = scanner.nextInt()

    val pokemon = generarPokemon(opcion)

    mostrarDatos(pokemon)

    val random = Random()
    val numeroAlAzar = 1 + random.nextInt(4)
    val pokemonSalvaje: Pokemon = generarPokemon(numeroAlAzar)

    println("Un ${pokemonSalvaje.nombre} salvaje ha aparecido!")

    do {
        println("${pokemon.nombre} HP:${pokemon.hp} | ${pokemonSalvaje.nombre} HP:${pokemonSalvaje.hp}")

        println("Elije un ataque:")
        for ((index, a) in pokemon.listaAtaques.withIndex()) {
            println("${index + 1} ${a.nombre}")
        }

        val ataqueSeleccionado = scanner.nextInt()

        if (procesarAtaque(pokemon, pokemonSalvaje, ataqueSeleccionado)) {
            break;
        }

        val ataqueAleatorio: Int = 1 + random.nextInt(pokemonSalvaje.listaAtaques.size)
        if (procesarAtaque(pokemonSalvaje, pokemon, ataqueAleatorio)) {
            break
        } else {
            println("Los dos pokémones siguen en pie!")
            println("...Continuamos!")
        }
    } while (pokemon.hp > 0 && pokemonSalvaje.hp > 0)
}

fun procesarAtaque(pokemonAtacante: Pokemon, pokemonDefensor: Pokemon, ataqueSeleccionado: Int): Boolean {
    val ataque = pokemonAtacante.obtenerAtaque(ataqueSeleccionado)
    println("${pokemonAtacante.nombre} ha usado ${ataque.nombre}")

    val valorDaño = calcularDaño(pokemonAtacante.ataque, pokemonAtacante.defensa, ataque)
    println("${pokemonDefensor.nombre} ha recibido $valorDaño puntos de daño")
    pokemonDefensor.hp -= valorDaño

    if (pokemonDefensor.hp <= 0) {
        println("${pokemonDefensor.nombre} se agotó!")
        println("${pokemonAtacante.nombre} ganó la batalla!")

        return true
    }
    return false
}

fun calcularDaño(valorAtaque: Int, valorDefensa: Int, ataque1: Ataque): Int = ((((2 * 1 + 10.0) / 250) * (valorAtaque / valorDefensa) * ataque1.poder + 2) * 1.5).toInt()

fun mostrarDatos(pokemon: Pokemon) {
    println("Has elegido a ${pokemon.nombre} \nHP:${pokemon.hp} \nATAQUE:${pokemon.ataque} \nDEFENSA:${pokemon.defensa}\n")
}

fun generarPokemon(opcion: Int): Pokemon = when (opcion) {
    Pokemones.BULBASAUR.id -> Pokemon("Bulbasaur", 45, 49, 49, arrayOf(Ataque("vine whip", 45), Ataque("tacle", 40)))
    Pokemones.CHARMANDER.id -> Pokemon("Charmander", 39, 52, 43, arrayOf(Ataque("scratch", 45), Ataque("ember", 40)))
    Pokemones.SQUIRTLE.id -> Pokemon("Squirtle", 44, 48, 65, arrayOf(Ataque("tackle", 45), Ataque("watergun", 40)))
    Pokemones.PIKACHU.id -> Pokemon("Pikachu", 35, 55, 40, arrayOf(Ataque("thunder shock", 45), Ataque("quick attack", 40)))
    else -> Pokemon("Missingno", 33, 136, 0, arrayOf(Ataque("pay day", 20), Ataque("blind", 15)))
}