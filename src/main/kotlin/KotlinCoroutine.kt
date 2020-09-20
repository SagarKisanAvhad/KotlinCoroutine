import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main() = runBlocking {// main thread
    println("Main work starts: ${Thread.currentThread().name}")
    launch {// main thread
        println("Fake work starts: ${Thread.currentThread().name}") // main thread
        delay(1000) //suspend coroutine and make our thread free
        println("Fake work ends: ${Thread.currentThread().name}") // main thread or other thread
    }

    delay(2000) // this is not right way

    println("Main work ends: ${Thread.currentThread().name}")
}