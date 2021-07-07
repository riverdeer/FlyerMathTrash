package com.tfbima.flyermath

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get reference to initial dataset
        val startFuelCheck = findViewById<Button>(R.id.start_button)
        val initialPoundsET = findViewById<EditText>(R.id.editTextNumber1)
        val initialTimeET = findViewById<EditText>(R.id.editTextTime1)

        val state1 = FuelState()

        // set on-click listener
        startFuelCheck.setOnClickListener {
            //gets the pounds from ET and into a double for maths
            val initialPoundsString = initialPoundsET.text.toString().also { println("this is $it") }
            val initialPoundsDouble = initialPoundsString.toDoubleOrNull().also { println("this is $it") }

            if (initialPoundsDouble is Double) {
                //stores the value into the initial fuel state
                state1.initialWeight = initialPoundsDouble
                //  stores and toasts toasts the current data
                val current = LocalDateTime.now()
                state1.initialTime = current
                state1.initialTimeLong  = state1.makeTimeToLong(current)

                val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HHmm")
                val initialTime = current.format(formatter)
                initialTimeET.setText(initialTime)
                println("Current Date and Time is: $current")
                println("Published Date and Time is: $initialTime")
                Toast.makeText(this@MainActivity, "The time is $current", Toast.LENGTH_LONG).show()
            }


        }

        // get reference to fina; dataset
        val endFuelCheck = findViewById<Button>(R.id.end_button)
        val finalPoundsET = findViewById<EditText>(R.id.editTextNumber2)
        val finalTimeET = findViewById<EditText>(R.id.editTextTime2)
        // set on-click listener
        endFuelCheck.setOnClickListener {
            //gets the pounds from ET and into a double for maths
            val finalPoundsString = finalPoundsET.text.toString().also { println("this is $it") }
            val finalPoundsDouble = finalPoundsString.toDoubleOrNull().also { println("this is $it") }

            if (finalPoundsDouble is Double){
                state1.finalWeight = finalPoundsDouble
                //  stores and toasts toasts the current data
                val current = LocalDateTime.now()
                state1.finalTime = current
                state1.finalTimeLong = state1.makeTimeToLong(current)

                val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HHmm")
                val finalTime = current.format(formatter)
                finalTimeET.setText(finalTime)
                println("Current Date and Time is: $current")
                println("Published Date and Time is: $finalTime")
                Toast.makeText(this@MainActivity, "The time is $current", Toast.LENGTH_LONG).show()
            }


        }
/*
        // get reference to math method
        val performFuelCheck = findViewById<Button>(R.id.math_button)
        performFuelCheck.setOnClickListener {

            state1.mathWeight()
            val weightDiff = state1.diffWeight
            println("mathWeight result is $weightDiff")
            state1.mathTime()
            val timeDiff = state1.diffTimeLong
            println("mathTime is $timeDiff")
        }
*/


    }
}


