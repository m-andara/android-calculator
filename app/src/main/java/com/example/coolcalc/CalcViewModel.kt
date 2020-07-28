package com.example.coolcalc

import android.util.Log

class CalcViewModel {

    private var operationsValues = arrayListOf<String>()
    private var currentVal: String = ""
    private val operations = arrayListOf<String>("/","x","+","-")
    private var firstNumber = ""
    private var currentOperation = ""
    private var secondNumber = ""
    private var total: Double = 0.0

    fun addOperation(value: String): String {

        if(operations.contains(value)) {

            if(currentVal.isNotEmpty()) {
                operationsValues.add(currentVal)
            }

            if(operationsValues.count() == 0) {
                return "invalid"
            }
            if(operationsValues.count() > 0 && operations.contains(operationsValues[operationsValues.count() - 1])) {
                operationsValues[operationsValues.count() - 1] = value
                return "repeat"
            } else {
                operationsValues.add(value)
            }

            this.currentVal = ""
            return value
        }

        if(value == "." && currentVal.isEmpty()) {
            currentVal = currentVal.plus("0.")
            return "emptyDecimal"
        }

        if(value == "." && currentVal.contains(".", true)) {
            return "repeatDecimal"
        }

        currentVal = currentVal.plus(value)
        return value
    }

    fun evaluateOperations(): String {

        if(currentVal.isNotEmpty()) {
            operationsValues.add(currentVal)
        }

        if(operationsValues.isNotEmpty() && operations.contains(operationsValues[operationsValues.count()-1])) {
            operationsValues.removeAt(operationsValues.count()-1)
        }

        if(operationsValues.count() == 0) {
            clearOperations()
            return ""
        }

        if(operationsValues.count() == 1) {
            clearOperations()
            return operationsValues[0]
        }

        for(x in 0 until operationsValues.count()) {

            if(operations.contains(operationsValues[x])) {
                currentOperation = operationsValues[x]
            }

            if(firstNumber.isNotEmpty() && !operations.contains(operationsValues[x])) {
                secondNumber = operationsValues[x]
            }

            if(firstNumber.isEmpty()) {
                firstNumber = operationsValues[x]
            }

            if(firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && currentOperation.isNotEmpty()) {
                when(currentOperation.toLowerCase()) {
                    "/" -> {
                        total = firstNumber.toDouble()/secondNumber.toDouble()
                        total = String.format("%.2f", total).toDouble()
                    }
                    "x" -> {
                        total = firstNumber.toDouble()*secondNumber.toDouble()
                        total = String.format("%.2f", total).toDouble()
                    }
                    "+" -> {
                        total = firstNumber.toDouble()+secondNumber.toDouble()
                        total = String.format("%.2f", total).toDouble()
                    }
                    "-" -> {
                        total = firstNumber.toDouble()-secondNumber.toDouble()
                        total = String.format("%.2f", total).toDouble()
                    }
                }

                firstNumber = total.toString()
                secondNumber = ""
                currentOperation = ""
            }

        }

        return total.toString()
    }

    fun clearOperations() {
        operationsValues.removeAll(operationsValues)
        firstNumber = ""
        secondNumber = ""
        currentOperation = ""
        total = 0.0
        this.currentVal = ""
    }
}