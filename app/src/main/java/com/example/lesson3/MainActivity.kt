package com.example.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mutableList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chembtn.setOnClickListener { _ ->
            if(binding.chemtext.text.toString().isNullOrBlank())
            {
                binding.toptx.text = "Chemical text can not be empty."
            }
            else if(mutableList.contains(binding.chemtext.text.toString()))
            {
                binding.toptx.text = "Chemical '${binding.chemtext.text}' is already available.";
            }
            else
            {
                binding.toptx.text = "Chemical '${binding.chemtext.text}' added successfully.";
                mutableList.add(binding.chemtext.text.toString())
                binding.chemtext.text.clear()
            }
        }

        binding.guessbtn.setOnClickListener{ _ ->
            if(mutableList.size == 0){
                binding.toptx.text = "No chemicals in the list to guess from."
                return@setOnClickListener
            }

            var random = (0 until mutableList.size).random()

            if(binding.guesstxt.text.toString().isNullOrBlank()){
                binding.toptx.text = "Guess text can not be empty."
            }
            else if(mutableList[random] == binding.guesstxt.text.toString()){
                binding.toptx.text =  "Congratulations! You guessed it right. It was ${mutableList[random]}."
            }
            else{
                binding.toptx.text =  "Sorry, wrong guess.The correct answer was ${mutableList[random]}."
            }
        }
    }
}