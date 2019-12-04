package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var carPrice : EditText
    lateinit var downPayment : EditText
    lateinit var loanPeriod : EditText
    lateinit var interestRate : EditText

    lateinit var loanText : TextView
    lateinit var interestText : TextView
    lateinit var monthlyText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carPrice = findViewById<EditText>(R.id.editTextCarPrice)
        downPayment = findViewById<EditText>(R.id.editTextDownPayment)
        loanPeriod = findViewById<EditText>(R.id.editTextLoanPeriod)
        interestRate = findViewById<EditText>(R.id.editTextInterestRate)

        loanText = findViewById<TextView>(R.id.textViewLoan)
        interestText = findViewById<TextView>(R.id.textViewInterest)
        monthlyText = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val calButton: Button = findViewById(R.id.buttonCalculate)
        val resetButton: Button = findViewById(R.id.buttonReset)
        calButton.setOnClickListener{calculateLoan()}
        resetButton.setOnClickListener{resetText()}


    }

    private fun calculateLoan(){
        val carLoan = carPrice.getText().toString().toDouble()-downPayment.getText().toString().toDouble()
        val interest = carLoan*interestRate.getText().toString().toDouble()/100*loanPeriod.getText().toString().toDouble()
        val monthlyPayment = (carLoan+interest)/loanPeriod.getText().toString().toDouble()/12

        loanText.text = "Car loan: RM"+carLoan
        interestText.text ="Interest: RM"+interest
        monthlyText.text = "Monthly repayment: RM"+monthlyPayment







    }

    private fun resetText(){
        loanText.setText(R.string.loan)
        interestText.setText(R.string.interest)
        monthlyText.setText(R.string.monthly_repayment)

        carPrice.setText("")
        downPayment.setText("")
        loanPeriod.setText("")
        interestRate.setText("")
    }


}
