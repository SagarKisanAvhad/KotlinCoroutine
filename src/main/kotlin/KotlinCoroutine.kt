import kotlin.concurrent.thread

fun main() {
    println("Main work starts: ${Thread.currentThread().name}")
    thread {
        println("Fake work starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake work ends: ${Thread.currentThread().name}")
    }
    println("Main work ends: ${Thread.currentThread().name}")
}