import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun funFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000)
        emit(i)
    }
}

fun main() = runBlocking {
    println(" Début de la collecte du Flow simple")

    funFlow().collect { value ->
        println(" Reçu : $value")
    }

    println(" Fin de la collecte du Flow simple")
}
