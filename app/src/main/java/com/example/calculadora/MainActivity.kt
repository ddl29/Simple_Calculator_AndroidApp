package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var current = ""
    var check1 = false
    var valor1 = 0
    var valor2 = 0
    var op = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.uno.setOnClickListener {
            updateCurrent("1")
        }
        binding.dos.setOnClickListener {
            updateCurrent("2")
        }
        binding.tres.setOnClickListener {
            updateCurrent("3")
        }
        binding.cuatro.setOnClickListener {
            updateCurrent("4")
        }
        binding.cinco.setOnClickListener {
            updateCurrent("5")
        }
        binding.seis.setOnClickListener {
            updateCurrent("6")
        }
        binding.siete.setOnClickListener {
            updateCurrent("7")
        }
        binding.ocho.setOnClickListener {
            updateCurrent("8")
        }
        binding.nueve.setOnClickListener {
            updateCurrent("9")
        }
        binding.zero.setOnClickListener {
            updateCurrent("0")
        }
        binding.division.setOnClickListener {
            saveValor1()
            op = "/"
        }
        binding.multi.setOnClickListener {
            saveValor1()
            op = "*"
        }
        binding.minus.setOnClickListener {
            saveValor1()
            op = "-"
        }
        binding.sum.setOnClickListener {
            saveValor1()
            op = "+"
        }
        binding.equal.setOnClickListener {
            saveValor2()
        }
        binding.ce.setOnClickListener {
            clearAll()
        }
    }

    private fun updateCurrent(digit: String){
        current += digit
        binding.campo.setText(current)
    }

    private fun saveValor1(){
        if(current != ""){
            valor1 = current.toInt()
            current = ""
            binding.campo.setText(current)
            check1 = true
        }else{
            Toast.makeText(this,"Ingresa el primer número antes de elegir una operación.", Toast.LENGTH_SHORT).show()
        }
    }
    private fun saveValor2(){
        if(current != "" && check1){
            valor2 = current.toInt()
            current = makeOperation()
            binding.campo.setText(current)
        }else{
            Toast.makeText(this,"Ingresa el segundo número antes de presionar el signo igual.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun makeOperation(): String{
        var res = 0
        if(op == "/"){
            res = valor1/valor2
        }else if(op == "*"){
            res = valor1*valor2
        }else if(op == "-"){
            res = valor1-valor2
        }else{
            res = valor1+valor2
        }
        return res.toString()
    }

    private fun clearAll(){
        valor1 = 0
        valor2 = 0
        op = ""
        current = ""
        binding.campo.setText("0")
    }
}