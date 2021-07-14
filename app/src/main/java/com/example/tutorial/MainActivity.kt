package com.example.tutorial

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addContactDialog = AlertDialog.Builder(this)
                .setTitle("Add Contact")
                .setMessage("Do you want to add Mr. Shithead to your contact list?")
                .setIcon(R.drawable.ic_settings)
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this, "You've added Mr. Shithead to your contact list", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "You did not add Mr. Shithead to your contact list", Toast.LENGTH_SHORT).show()
                }
                .create()


        btnDialog1.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf("First Item", "Second Item", "Third Item")
        val singleChoiceDialog = AlertDialog.Builder(this)
                .setTitle("Choose one of these options")
                .setSingleChoiceItems(options, 0)  {_, which ->
                    Toast.makeText(this, "You chose ${options[which]}", Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "You denied the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .create()

        btnDialog2.setOnClickListener {
            singleChoiceDialog.show()
        }

        val multiChoiceDialog = AlertDialog.Builder(this)
                .setTitle("Choose multiple options")
                .setMultiChoiceItems(options, booleanArrayOf(false, false, false)) {_, which, isChecked ->
                    if(isChecked) Toast.makeText(this, "You chose ${options[which]}", Toast.LENGTH_SHORT).show()
                    else Toast.makeText(this, "You unchecked ${options[which]}", Toast.LENGTH_SHORT).show()

                }
                .setPositiveButton("Yes") { _, _ ->
                    Toast.makeText(this, "You accepted the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("No") { _, _ ->
                    Toast.makeText(this, "You denied the MultiChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                .create()

        btnDialog3.setOnClickListener {
            multiChoiceDialog.show()
        }
    }

}
