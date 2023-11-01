package com.kotlincourse.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlincourse.assignment2.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var foodList = arrayListOf<String>("Hamburger", "Pizza", "Mexican", "American", "Chinese");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_main)

        binding.btnDecide.setOnClickListener {
            binding.tvSelectedFood.text = getRandomFood();
        }


        binding.btnAddNewFood.setOnClickListener {
            if(binding.edAddNewFood.text.isEmpty())
            {
                Toast.makeText(this, "Please enter food name", Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }

            if(checkIfExist(binding.edAddNewFood.text.toString()))
            {
                Toast.makeText(this,"${binding.edAddNewFood.text} is already exist" , Toast.LENGTH_SHORT).show();
                return@setOnClickListener;
            }
            foodList.add(binding.edAddNewFood.text.toString())
            binding.edAddNewFood.text.clear();
        }
    }

    private fun checkIfExist(food: String): Boolean {
        return foodList.stream().anyMatch { s -> s.equals(food,true) }
    }

    private fun getRandomFood(): String {
        val index = Random().nextInt(foodList.size)
        return foodList.get(index);
    }

}