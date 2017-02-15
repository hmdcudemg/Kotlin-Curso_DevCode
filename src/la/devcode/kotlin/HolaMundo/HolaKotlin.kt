package HolaMundo

import java.util.*

/**
 * Created by DEMG on 15/02/2017.
 */
fun main(args: Array<String>) {
    println("Escribe tu nombre o pulsa [Enter o Entrar] para seguir anónimo:")
    val scanner = Scanner(System.`in`)
    val nextLine = scanner.nextLine()

    println("Hola ${if (nextLine != "") nextLine else "Kotlin"}!")
}