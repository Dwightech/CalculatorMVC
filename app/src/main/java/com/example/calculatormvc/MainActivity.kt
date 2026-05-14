package com.example.calculatormvc

import android.os.Bundle
import android.content.Intent
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import models.CalculatorModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.editTextNumber)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)
        val btnAdd = findViewById<Button>(R.id.button_add)
        val btnSubtract = findViewById<Button>(R.id.button_subtract)
        val btnMultiply = findViewById<Button>(R.id.button_multiply)
        val btnDivide = findViewById<Button>(R.id.button_divide)
        val btnPercent = findViewById<Button>(R.id.button_percent)
        val btnSqrt = findViewById<Button>(R.id.button_sqrt)
        val btnClear = findViewById<Button>(R.id.button_clear)
        val result = findViewById<TextView>(R.id.textViewAnswer)

        val btnHist = findViewById<Button>(R.id.buttonHistory)

        btnHist.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        btnAdd.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num1 = n1
            CalculatorModel.num2 = n2

            val calcResult = CalculatorModel.add()
            result.text = "Answer: $calcResult"
            CalculatorModel.addHistory(calcResult.toString())
        }

        btnSubtract.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num1 = n1
            CalculatorModel.num2 = n2
            val calcResult = CalculatorModel.subtract()
            result.text = "Answer: $calcResult"
            CalculatorModel.addHistory(calcResult.toString())
        }

        btnMultiply.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num1 = n1
            CalculatorModel.num2 = n2
            val calcResult = CalculatorModel.multiply()
            result.text = "Answer: $calcResult"
            CalculatorModel.addHistory("$n1 × $n2 = $calcResult")
        }

        btnDivide.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num1 = n1
            CalculatorModel.num2 = n2
            val calcResult = CalculatorModel.divide()
            result.text = "Answer: $calcResult"
            CalculatorModel.addHistory("$n1 ÷ $n2 = $calcResult")
        }

        btnPercent.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num1 = n1
            CalculatorModel.num2 = n2
            val calcResult = CalculatorModel.percent()
            result.text = "Answer: $calcResult"
            CalculatorModel.addHistory("$n1 % $n2 = $calcResult")
        }

        btnSqrt.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            CalculatorModel.num1 = n1
            val calcResult = CalculatorModel.sqrt()
            result.text = "Answer: $calcResult"
            CalculatorModel.addHistory("√$n1 = $calcResult")
        }

        btnClear.setOnClickListener {
            num1.setText("")
            num2.setText("")
            result.text = "Answer: 0.0"
        }
    }
}
