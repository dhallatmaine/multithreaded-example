class CalculatorService : Calculator {

    override fun calc(stocks: List<Stock>) {
        val deltaDeterminer = DeltaDeterminer()
        for (stock in stocks) {
            deltaDeterminer.delta(stock)
        }
    }

}