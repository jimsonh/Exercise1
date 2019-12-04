package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calButton: Button = findViewById(R.id.buttonCalculate)
        val resetButton: Button = findViewById(R.id.buttonReset)
        calButton.setOnClickListener{calculateLoan()}
        resetButton.setOnClickListener{resetText()}


    }

    private fun calculateLoan(){

        val carPrice = findViewById<TextView>(R.id.editTextCarPrice).getText().toString().toDouble()
        val downPayment = findViewById<TextView>(R.id.editTextDownPayment).getText().toString().toDouble()
        val loanPeriod = findViewById<TextView>(R.id.editTextLoanPeriod).getText().toString().toDouble()
        val interest = findViewById<TextView>(R.id.editTextInterestRate).getText().toString().toDouble()

        val loan = findViewById<TextView>(R.id.textViewLoan)
        val interestOverTime = findViewById<TextView>(R.id.textViewInterest)
        val monthlyPayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val loanDouble = carPrice-downPayment
        val interestOverTimeDouble = loanDouble*interest/100*loanPeriod
        val monthlyPaymentDouble = (loanDouble+interestOverTimeDouble)/loanPeriod/12

        loan.text = "RM"+loanDouble
        interestOverTime.text ="RM"+interestOverTimeDouble
        monthlyPayment.text = "RM"+monthlyPaymentDouble



    }

    private fun resetText(){
        val carPrice = findViewById<TextView>(R.id.editTextCarPrice)
        val downPayment = findViewById<TextView>(R.id.editTextDownPayment)
        val loanPeriod = findViewById<TextView>(R.id.editTextLoanPeriod)
        val interest = findViewById<TextView>(R.id.editTextInterestRate)

        val loan = findViewById<TextView>(R.id.textViewLoan)
        val interestOverTime = findViewById<TextView>(R.id.textViewInterest)
        val monthlyPayment = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        carPrice.text=""
        downPayment.text=""
        loanPeriod.text=""
        interest.text=""


        loan.text = ""
        interestOverTime.text = ""
        monthlyPayment.text = ""
    }


}
