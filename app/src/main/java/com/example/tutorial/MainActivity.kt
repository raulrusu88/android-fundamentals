package com.example.tutorial

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Implicit intents -> An action that gives the user the choice to open an action with a different application
//        eg: Making a photo (you give the user the possibility and they choose which application they make the photos
//        eg: Share button -> the user chooses the application to share the current post

        btnTakePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"  // we can specify type of files image/png , image/jpg, with * we take everything
                startActivityForResult(it, 0)
            }
        }
    }

//    To receive that activity, we need to override the onActivityResult function and check if there's data
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == RESULT_OK && requestCode == 0)  {
            val uri = data?.data
            ivPhoto.setImageURI(uri)
        }
    }
}
