package Ahorcado
fun main() {
    val rm = ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(5000)
    val lista = mutableListOf("platano", "manzana", "aguaymanto", "lucuma", "pera")
    println("Hola! Bienvenido al Ahorcado")
    val palabraAdivinar = lista.random()
    val palabraOculta = StringBuilder("*".repeat(palabraAdivinar.length))
    var errores = 0
    val maxErrores = 7

    val letrasAdivinadas = mutableListOf<Char>()

    while (errores < maxErrores && palabraOculta.contains("*")) {
        println("Palabra a adivinar: $palabraOculta")
        println("Introduce una letra:")
        val letraUsuarioo = readln().first()

        if (letrasAdivinadas.contains(letraUsuarioo)) {
            println("Ya ingresaste esta letra, ingresa otra distinta.")
            continue
        }


        letrasAdivinadas.add(letraUsuarioo)

        var aciertos = false
        for (i in palabraAdivinar.indices) {
            if (palabraAdivinar[i] == letraUsuarioo) {
                palabraOculta.setCharAt(i, letraUsuarioo)
                aciertos = true
            }
        }

        if (aciertos) {
            println("¡Muy bien! La palabra por descubrir ahora es: $palabraOculta")
        } else {
            errores++
            DibujoAhorcado.dibujar(errores)
            println("Letra incorrecta. Te quedan ${maxErrores - errores} intentos.")
        }
    }

    if (!palabraOculta.contains("*")) {
        println("¡FELICIDADES, HAS GANADO!")
    } else {
        println("Perdiste, suerte para la próxima vez.")
    }

    rm.cerrar()
}
