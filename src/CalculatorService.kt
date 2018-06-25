class CalculatorService : Calculator {

    override fun calc(stocks: List<Stock>) {
        val deltaDeterminer = DeltaDeterminer()
        for (stock in stocks) {
            println(stock.ticker + " " + stock.price)
            deltaDeterminer.delta(stock)
        }
    }

}