package la.devcode.kotlin.Enumeradores

/**
 * Created by DEMG on 15/02/2017.
 */
enum class Moneda(val simbolo: String) {
    USD("$"), PEN("S/."), ARS("$"), MXN("$"), BOB("\$b"), CLP("$"), COP("$"), PYG("Gs"), UYU("\$U");

    fun formato(monto: Double) = "$simbolo $monto"
}

fun main(args: Array<String>) {
    println(Moneda.USD)
    println(Moneda.BOB.simbolo)
    println(Moneda.MXN.formato(500.0))
}