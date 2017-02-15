package Funciones

/**
 * Created by DEMG on 15/02/2017.
 */

fun main(args: Array<String>) {
    println(sumar(4, 5))
    println(sumarSimple(9, 5))
    println(esMayorDeEdad(17))
    println(esMayorDeEdad(18))
}

fun sumar(a: Int, b: Int): Int {
    return a + b
}

fun sumarSimple(a: Int, b: Int) = a + b

fun esMayorDeEdad(edad: Int) = if (edad >= 18) true else false