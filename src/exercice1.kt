
import kotlinx.coroutines.*

suspend fun verifierDisponibilite() {
    println(" Vérification des ingrédients...")
    delay(2000)
    println(" Ingrédients disponibles !")
}

suspend fun preparerCommande() {
    println(" Préparation de la commande...")
    delay(5000)
    println(" Commande prête !")
}

suspend fun livrerRepas() = withContext(Dispatchers.IO) {
    println(" Livraison du repas en cours...")
    delay(3000)
    println(" Repas livré avec succès !")
}

fun main() = runBlocking {
    println("--- Gestion de commande du restaurant ---")

    //  Vérifier la disponibilité (bloque jusqu’à la fin)
    verifierDisponibilite()

    // Préparer la commande (bloque jusqu’à la fin)
    preparerCommande()

    // Livrer le repas (exécutée dans le contexte IO)
    livrerRepas()

    println(" Toutes les étapes sont terminées avec succès !")
}
