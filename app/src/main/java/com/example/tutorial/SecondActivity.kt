package com.example.tutorial

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person // cast this as Person

        val name = person.name.toString()

        tvPerson.text = name

        btnGoBack.setOnClickListener {
            // Goes back, clears the activity stack
            finish()
        }
    }
}