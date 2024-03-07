package com.example.personapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var userName: EditText
    private lateinit var btnSubmit: Button
    private lateinit var displayName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val person = Person()
        person.userName = findViewById(R.id.etName)
        person.btnSubmit = findViewById(R.id.btnSubmit)
        person.displayName = findViewById(R.id.displayName)

        person.btnSubmit.setOnClickListener{

            //pass the value to the next page
            val intent = Intent(this,displayDetails::class.java)

            //convert the input value toString()
            val message = person.userName.text.toString()

            intent.putExtra("NAME", message)
            person.displayName.text = "Hello, $message !"
//            Toast.makeText(this,"Your name is $message",Toast.LENGTH_LONG).show()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}