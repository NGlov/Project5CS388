package com.example.project5cs388

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val foodNameEditText = findViewById<EditText>(R.id.et_food_name)
        val caloriesEditText = findViewById<EditText>(R.id.et_calories)
        val recordButton = findViewById<Button>(R.id.btn_record_food)

        val db = AppDatabase.getDatabase(this)

        recordButton.setOnClickListener {
            val name = foodNameEditText.text.toString()
            val calories = caloriesEditText.text.toString()

            if (name.isNotEmpty() && calories.isNotEmpty()) {
                val foodItem = FoodItem(name = name, calories = calories)
                lifecycleScope.launch(Dispatchers.IO) {
                    db.foodDao().insert(foodItem)
                    finish()
                }
            }
        }
    }
}
