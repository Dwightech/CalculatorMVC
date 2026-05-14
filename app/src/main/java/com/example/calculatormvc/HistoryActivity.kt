package com.example.calculatormvc

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import models.CalculatorModel

class HistoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)

        val btnCalc = findViewById<Button>(R.id.button)
        val listViewHistory = findViewById<ListView>(R.id.listViewHistory)

        val historyList = CalculatorModel.getHistory()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, historyList)
        listViewHistory.adapter = adapter

        btnCalc.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        listViewHistory.setOnItemLongClickListener { _, _, position, _ ->
            CalculatorModel.deleteHistory(position)
            adapter.notifyDataSetChanged()
            true
        }
    }
}