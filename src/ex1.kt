import kotlinx.coroutines.*

fun main() = runBlocking {
    println(" Exemple avec Job classique")

    // Création d’un scope avec un Job
    val job = Job()
    val scope = CoroutineScope(Dispatchers.Default + job)

    scope.launch {
        delay(500)
        println(" Coroutine 1 : Erreur détectée !")
        throw Exception("Erreur dans Coroutine 1")
    }

    scope.launch {
        try {
            delay(1000)
            println("Coroutine 2 : Terminé avec succès !")
        } catch (e: CancellationException) {
            println("Coroutine 2 : Annulée à cause de l’erreur de la première")
        }
    }

    // On attend la fin des tâches
    delay(1500)
    println("🔚 Fin de l’exemple avec Job\n")
}
