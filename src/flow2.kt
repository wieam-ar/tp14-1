import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun generateEvenFlow(): Flow<Int> = flow {
    for (i in 2..10 step 2) {
        delay(1000)
        emit(i)
    }
}

fun main() = runBlocking {
    println(" Début de la collecte du Flow pair")

    generateEvenFlow().collect { value ->
        println("Nombre pair reçu : $value")
    }

    println(" Fin de la collecte du Flow pair")
}
