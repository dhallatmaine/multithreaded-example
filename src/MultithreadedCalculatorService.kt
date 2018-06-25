import java.util.concurrent.Callable
import java.util.concurrent.Executors

class MultithreadedCalculatorService : Calculator {

    override fun calc(stocks: List<Stock>) {
        val executorService = Executors.newFixedThreadPool(5)

        val taskList = ArrayList<Callable<Stock>>()
        for (stock in stocks) {
            val futureStock = MTDeltaDeterminer(stock)
            taskList.add(futureStock)
        }

        executorService.invokeAll(taskList)
    }

}

class MTDeltaDeterminer(val stock: Stock) : Callable<Stock> {

    override fun call(): Stock {
        val deltaDeterminer = DeltaDeterminer()
        deltaDeterminer.delta(stock)
        return stock
    }
}