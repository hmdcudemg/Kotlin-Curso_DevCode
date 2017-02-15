package clases

/**
 * Created by DEMG on 15/02/2017.
 */
class Persona(val nombre: String, var edad: Int) {
    val esMayorDeEdad: Boolean
        get() = if (edad >= 18) true else false
}