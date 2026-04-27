package com.example.calculatormvc

import android.os.Bundle
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculatormvc.ui.theme.CalculatorMVCTheme
import models.CalculatorModel

class MainActivity : ComponentActivity() {
    private val calcModel = CalculatorModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Get input from UI
        val num1 = findViewById<EditText>(R.id.editTextNumber)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)
        val btnAdd = findViewById<Button>(R.id.button_add)
        val btnSubtract = findViewById<Button>(R.id.button_subtract)
        val btnMultiply = findViewById<Button>(R.id.button_multiply)
        val btnDivide = findViewById<Button>(R.id.button_divide)
        val btnClear = findViewById<Button>(R.id.button_clear)
        val result = findViewById<TextView>(R.id.textViewAnswer)

        btnAdd.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            calcModel.num1 = n1
            calcModel.num2 = n2
            val sum = n1 + n2
            result.text = sum.toString()

            //Use the Model
            val calcResult = calcModel.add()
            result.text = "Answer: $calcResult"
        }
        btnSubtract.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            calcModel.num1 = n1
            calcModel.num2 = n2
            val calcResult = calcModel.subtract().toString()
            result.text = "Answer: $calcResult"
        }
        btnMultiply.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            calcModel.num1 = n1
            calcModel.num2 = n2
            val calcResult = calcModel.multiply()
            result.text = "Answer: $calcResult"
        }
        btnDivide.setOnClickListener {
            val n1 = num1.text.toString().toDoubleOrNull() ?: 0.0
            val n2 = num2.text.toString().toDoubleOrNull() ?: 0.0
            calcModel.num1 = n1
            calcModel.num2 = n2
            val calcResult = calcModel.divide()
            result.text = "Answer: $calcResult"
        }
        btnClear.setOnClickListener {
            num1.setText("")
            num2.setText("")
            result.text = "Answer: 0.0"
        }
//        setContent {
//            CalculatorMVCTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }
//        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorMVCTheme {
        Greeting("Android")
    }
}