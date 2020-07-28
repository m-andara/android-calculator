package com.example.coolcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val calcData = CalcViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnZero = findViewById<Button>(R.id.zero)
        btnZero.setOnClickListener(this)
        val btnOne = findViewById<Button>(R.id.one)
        btnOne.setOnClickListener(this)
        val btnTwo = findViewById<Button>(R.id.two)
        btnTwo.setOnClickListener(this)
        val btnThree = findViewById<Button>(R.id.three)
        btnThree.setOnClickListener(this)
        val btnFour = findViewById<Button>(R.id.four)
        btnFour.setOnClickListener(this)
        val btnFive = findViewById<Button>(R.id.five)
        btnFive.setOnClickListener(this)
        val btnSix = findViewById<Button>(R.id.six)
        btnSix.setOnClickListener(this)
        val btnSeven = findViewById<Button>(R.id.seven)
        btnSeven.setOnClickListener(this)
        val btnEight = findViewById<Button>(R.id.eight)
        btnEight.setOnClickListener(this)
        val btnNine = findViewById<Button>(R.id.nine)
        btnNine.setOnClickListener(this)
        val btnDiv = findViewById<Button>(R.id.divide)
        btnDiv.setOnClickListener(this)
        val btnMult = findViewById<Button>(R.id.multiply)
        btnMult.setOnClickListener(this)
        val btnAdd = findViewById<Button>(R.id.add)
        btnAdd.setOnClickListener(this)
        val btnSub = findViewById<Button>(R.id.subtract)
        btnSub.setOnClickListener(this)
        val btnEval = findViewById<Button>(R.id.evaluate)
        btnEval.setOnClickListener(this)
        val btnClear = findViewById<Button>(R.id.clear)
        btnClear.setOnClickListener(this)
        val btnDecimal = findViewById<Button>(R.id.decimal)
        btnDecimal.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val button = findViewById<Button>(v?.id!!)
        addValue(button.text.toString())
    }

    private fun addValue(value: String) {
        val valuesView = findViewById<TextView>(R.id.text_values)
        when (value.toLowerCase()) {
            "clear" -> {
                valuesView.text = ""
                calcData.clearOperations()
            }
            "=" -> {
                val result = calcData.evaluateOperations()
                valuesView.text = ""
                valuesView.text = valuesView.text.toString().plus(result)
                calcData.clearOperations()
                calcData.addOperation(result)
            }
            else -> {
                val res = calcData.addOperation(value)
                val text = valuesView.text.toString()
                if(res.equals("repeat")) {
                    val trimmedText = text.substring(0, text.length - 1)
                    valuesView.text = trimmedText.plus(value)
                } else if(res.equals("emptyDecimal")) {
                    valuesView.text = text.plus("0.")
                } else if(res.equals("repeatDecimal") || res.equals("invalid")) {
                    valuesView.text = valuesView.text.toString()
                }
                else {
                    valuesView.text = text.plus(value)
                }
            }
        }
    }

}