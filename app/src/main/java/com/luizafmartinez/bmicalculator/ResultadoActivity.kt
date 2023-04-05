package com.luizafmartinez.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras

        if (bundle != null) {
            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            // "Peso informado $peso kg"
            // "Altura informada $peso m"
            textPeso.text = "Informed weight $peso lbs"
            textAltura.text = "Informed height $altura in"

            //val imc = peso / (altura * altura)
            //In US units: BMI = weight (lb) ÷ height2 (inches) * 703

            val bmi = (peso / (altura * altura)) * 703

            val resultado =
                if (bmi < 18.5) "Under weight"  //Baixo
                else if (bmi in 18.5..24.9) "Normal"  //Normal
                else if (bmi in 25.0..29.9) "Overweight"  // Sobrepeso
                else "Obese"  // Obeso

            textResultado.text = resultado




        }


    }
}