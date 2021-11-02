package com.example.notesappfragments

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class Update : AppCompatActivity() {
    lateinit var updateText: EditText
    lateinit var updateBtn: Button
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        updateBtn = findViewById(R.id.updateBtn)
        updateText = findViewById(R.id.updateText)
        updateBtn.setOnClickListener {
            if (updateText.text.isEmpty()) {
                Toast.makeText(applicationContext, "Fill all filed please!! ", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = intent
                val ID = intent.getIntExtra("ID",0)
                myViewModel.updateNote(ID, updateText.text.toString())
                Toast.makeText(
                    applicationContext,
                    "data updated successfully! ",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    /*
    fun update(ID: Int) {
        //first we create a variable to hold an AlertDialog builder
        val dialogBuilder = AlertDialog.Builder(this)
        // then we set up the input
        val input = EditText(this)
        input.hint = "Enter new note"
        // positive button text and action
        dialogBuilder.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, id ->
            val str = input.text.toString()
            if (str.isEmpty()) {
                Toast.makeText(applicationContext, "Fill all filed please!! ", Toast.LENGTH_SHORT).show()
            } else {
                myViewModel.updateNote(ID,str)
                Toast.makeText(applicationContext, "data updated successfully! ", Toast.LENGTH_SHORT).show()
            }
        })
            // negative button text and action
            .setNegativeButton("cancel", DialogInterface.OnClickListener { dialog, id ->
            })
        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle("Update Note")
        // add the Edit Text
        alert.setView(input)
        // show alert dialog
        alert.show()
    }
     */
}