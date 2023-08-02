package com.example.room

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var insertButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var surnameEditText: EditText
    private lateinit var professionEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        insertButton = findViewById(R.id.insertButton)
        nameEditText = findViewById(R.id.nameEditText)
        surnameEditText = findViewById(R.id.surnameEditText)
        professionEditText = findViewById(R.id.professionEditText)

        insertButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val surname = surnameEditText.text.toString()
            val profession = professionEditText.text.toString()

            val user = User(name = name, surname = surname, profession = profession)//  In the code provided, the User object is being created to encapsulate the user's information as a single entity. It allows you to conveniently pass the user's data as a single object to the insertUser() function in the UserDao interface.                By creating a User object, you can ensure that the user's data is properly structured and organized before inserting it into the database. It helps to maintain the integrity and consistency of the user's information.

            lifecycleScope.launch(Dispatchers.IO) {
                MyApp.database.userDao().insertUser(user)

                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity,"Data inserted Successsfully", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val getButton: Button = findViewById(R.id.getButton)
        getButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}