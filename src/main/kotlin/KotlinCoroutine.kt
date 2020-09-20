import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() = runBlocking {// T1 = main thread
    println("Main work starts: ${Thread.currentThread().name}")
    val jobDeferred: Deferred<Int> = async {// T1 = main thread
        println("Fake work starts: ${Thread.currentThread().name}") // main thread(T1)
        delay(1000) //suspend coroutine and make our thread free
        println("Fake work ends: ${Thread.currentThread().name}") // main thread(T1) or other thread
        33
    }

    // jobDeferred.join() // returned value Not needed + need to wait till coroutine
    val returnValue = jobDeferred.await() // returned value needed + need to wait till coroutine
    println(returnValue)
    println("Main work ends: ${Thread.currentThread().name}") // this line will execute after coroutine finish its work
}