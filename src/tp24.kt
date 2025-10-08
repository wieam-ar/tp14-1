import kotlinx.coroutines.*

suspend fun lancher(){
    println("debut de function ")
    val job = GlobalScope.launch {
        println("demarage du coroutine 1")
        delay(3000L)
        println("Coroutine 1 est terminer")

    }
    val job2 = GlobalScope.launch {
        println("demarage du coroutine 2")
        delay(4000L)
        println("coroutine 2 est terminer ")

    }
    job.join()
    job2.join()
}
suspend fun asynfunction(){
    println("demarage du fonction asyn ")
    val first = GlobalScope.async {
        println("calcule 1")
        delay(5000L)
        10
    }
    val second = GlobalScope.async {
        println("calcule 2")
        delay(5500L)
        20
    }
    var result1 = first.await()
    var result2 = second.await()
    print("le resultat final : ${result1 + result2}")
}
fun main() = runBlocking {
    println(" Début du programme principal (runBlocking)")
    lancher()
    asynfunction()
    println(" Fin du programme principal")
}