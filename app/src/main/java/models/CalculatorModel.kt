package models

class CalculatorModel {

    private val history = mutableListOf<String>()

    fun addHistory(operation: String) {
        history.add(operation)
    }

    fun getHistory(): List<String> = history

    fun deleteHistory(index: Int) {
        history.removeAt(index)
    }


    //Attributes
    var num1: Double = 0.0
    var num2: Double = 0.0

    //Operations
    fun add(): Double = num1 + num2
    fun subtract(): Double = num1 - num2
    fun multiply(): Double = num1 * num2
    fun divide(): Double {
        return if (num2!=0.0) num1 / num2 else 0.0
    }
    fun percent(): Double = (num1 * num2) / 100
    fun sqrt(): Double = Math.sqrt(num1)

}