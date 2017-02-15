package la.devcode.kotlin.clases

/**
 * Created by DEMG on 15/02/2017.
 */
fun main(args: Array<String>) {
    val persona = Persona("David", 22)

    println(persona.nombre)
    println(persona.edad)
    println(persona.esMayorDeEdad)

    persona.edad = 18
    println(persona.edad)
    println(persona.esMayorDeEdad)
}