package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.databinding.ActivityMainBinding
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.button.setOnClickListener { calculateTip() }
        }

    private fun calculateTip() {
        val cost : Double = binding.numberInput.text.toString().toDouble()
        val selectedId : Int = binding.options.checkedRadioButtonId
        val tipPercentage : Double = when(selectedId){
            R.id.radioButton -> 0.2
            R.id.radioButton2 -> 0.18
            else -> 0.15
        }
        var tip : Double = cost*tipPercentage
        val roundUp : Boolean = binding.switch2.isChecked
        if (roundUp){
            tip = ceil(tip)
        }
        binding.textView3.text = tip.toString()
    }
}