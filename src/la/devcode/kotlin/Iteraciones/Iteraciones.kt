package la.devcode.kotlin.Iteraciones

/**
 * Created by DEMG on 15/02/2017.
 */
fun main(args: Array<String>) {
    ciclosFor()
}

fun ciclosFor() {
    // Ciclo que cuenta del 1 al 10(incluyendolo)
    for (i in 1..10) {
        println(i)
    }
    println()
    // Ciclo que cuenta del 1 al 10(no incluyendolo)
    for (i in 1 until 10) {
        println(i)
    }
    println()
    // Ciclo que cuenta en forma descendente del 20 al 10
    for (i in 20 downTo 10) {
        println(i)
    }
    println()
    // Ciclo que cuenta del 1 al 10(incluyendolo) y contando de 2 en 2
    for (i in 1 until 10 step 2) {
        println(i)
    }
    println()
    // ciclo que recorre un arreglo, mejor onocido como foreach
    var arreglo = arrayListOf("A", "B", "C", "D", "E")
    for (c in arreglo) {
        println(c)
    }
    println()
    // ciclo que recorre un arreglo con indices, mejor onocido como foreach
    for ((index, c) in arreglo.withIndex()) {
        println("$index $c")
    }
}

fun cilosWhile() {
    var i = 0
    while (i < 5) {
        println(i)
        i++
    }
    i = 0
    println()
    do {
        println(i)
        i++
    } while (i < 8)
}