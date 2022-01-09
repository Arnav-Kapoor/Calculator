package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var inputBox:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputBox=findViewById(R.id.inputBox)
    }

    var dot:Boolean=false
    var opp:Boolean=true
    var oldNum:String=""
    var operator:String="x"
    //for digit buttons
        fun getNumbers(view:View){
        if(opp){
            inputBox.text=""
        }
        opp=false
            val selectedBtn=view as Button
        var getText:String=inputBox.text.toString()
        inputBox.text=getText



        when(selectedBtn.id){
            R.id.bt0->{
                getText+="0"
            }
            R.id.bt1->{
                getText+="1"
            }
            R.id.bt2->{
                getText+="2"
            }
            R.id.bt3->{
                getText+="3"
            }
            R.id.bt4->{
                getText+="4"
            }
            R.id.bt5->{
                getText+="5"
            }
            R.id.bt6->{
                getText+="6"
            }
            R.id.bt7->{
                getText+="7"
            }
            R.id.bt8->{
                getText+="8"
            }
            R.id.bt9->{
                getText+="9"
            }
            R.id.btDot-> {
                if (!dot) {
                    getText+="."
                }
                dot=true
            }
        }
        inputBox.text=getText

            }




    fun getOpp(view: View) {
        var selectedOpp = view as Button

        when (selectedOpp.id) {
            R.id.btAdd-> {
                operator = "+"
            }
            R.id.btSub-> {
                operator = "-"
            }
            R.id.btSqrt-> {
                operator = "^(1/2)"
            }
            R.id.btMul-> {
                operator = "x"
            }
            R.id.btDivide-> {
                operator = "/"
            }
            R.id.btPercent->{
                operator="%"
            }

        }

        oldNum=inputBox.text.toString()
        dot=false
        opp=true
        inputBox.text=operator

    }

    fun getResult(view: View){


        var result:Double?=null
        if(operator=="^(1/2)"){
            result= sqrt(oldNum.toDouble())
        }
        else {

            val newNum = inputBox.text.toString()

            when (operator) {
                "+" -> {
                    result = oldNum.toDouble() + newNum.toDouble()
                }
                "-" -> {
                    result = oldNum.toDouble() - newNum.toDouble()
                }
                "x" -> {
                    result = oldNum.toDouble() * newNum.toDouble()
                }
                "/" -> {
                    result = oldNum.toDouble() / newNum.toDouble()
                }
                "%" -> {
                    result = (oldNum.toDouble() * newNum.toDouble()) / 100
                }

            }
        }
        dot=true
        inputBox.text=result.toString()
        }
    fun clearInput(view: View){
        inputBox.text=""
        dot=false
        opp=true
    }

    }



