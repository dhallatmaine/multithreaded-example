import java.util.*
import kotlin.system.measureTimeMillis

fun main(args : Array<String>) {
    val stocks = Arrays.asList(
            Stock("appl", 100),
            Stock("appl", 150),
            Stock("amzn", 90),
            Stock("amzn", 95),
            Stock("abba", 10),
            Stock("yhoo", 300),
            Stock("tsla", 240),
            Stock("goog", 550),
            Stock("chst", 15),
            Stock("idxx", 115))

    val calculator = CalculatorService()

    var timeElapsed = measureTimeMillis {
        calculator.calc(stocks)
    }
    println("Serial: Total time elapsed: $timeElapsed")


    val multithreadedCalculator = MultithreadedCalculatorService()
    timeElapsed = measureTimeMillis {
        multithreadedCalculator.calc(stocks)
    }
    println("Multithreaded: Total time elapsed: $timeElapsed")
}