package la.devcode.kotlin.SmartCast

/**
 * Created by DEMG on 15/02/2017.
 */
// Operacion a Realizar 3 X 4 X 2 + 2 + 4
interface Expresion

class Numero(val valor: Int) : Expresion
class Sumar(val valorA: Expresion, val valorB: Expresion) : Expresion
class Multiplicar(val valorA: Expresion, val valorB: Expresion) : Expresion

fun evaluarExpresion(expresion: Expresion): Int {
    if (expresion is Numero) {
        return expresion.valor
    } else if (expresion is Sumar) {
        return evaluarExpresion(expresion.valorA) + evaluarExpresion(expresion.valorB)
    } else if (expresion is Multiplicar) {
        return evaluarExpresion(expresion.valorA) * evaluarExpresion(expresion.valorB)
    } else {
        throw java.lang.IllegalArgumentException("No se puede reconocer la expresión")
    }
}

fun main(args: Array<String>) {
    println(evaluarExpresion(Sumar(Sumar(Multiplicar(Multiplicar(Numero(3), Numero(4)), Numero(2)), Numero(2)), Numero(4))))
}