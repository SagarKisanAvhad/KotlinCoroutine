import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {
    println("Main work starts: ${Thread.currentThread().name}")
    GlobalScope.launch {
        println("Fake work starts: ${Thread.currentThread().name}")
        delay(1000) //pretend some work like uploading file
        println("Fake work ends: ${Thread.currentThread().name}")
    }

    delay(2000)

    println("Main work ends: ${Thread.currentThread().name}")
}