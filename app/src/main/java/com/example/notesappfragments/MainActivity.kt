package com.example.notesappfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


/*
val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
val navController = navHostFragment.navController
 */

//using room database
class MainActivity : AppCompatActivity() {
//    lateinit var editText: EditText
//    lateinit var button: Button
//    lateinit var myRv: RecyclerView
//    //var list = ArrayList<String>()
//    lateinit var lv: List<Note>
//    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java)}
    //lateinit var Rv : RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
}
}

/*
 editText = findViewById<EditText>(R.id.editText)
        button = findViewById<Button>(R.id.button)
        myRv = findViewById<RecyclerView>(R.id.recyclerView)

        lv = arrayListOf()
        NoteDatabase.getInstance(applicationContext)
        // Rv = RecyclerViewAdapter(this)

        myViewModel.getNotes().observe(this, {
                notes -> //Rv.update(notes)
         //   myRv.adapter = RecyclerViewAdapter(this,notes)
         //   myRv.layoutManager = LinearLayoutManager(this)
        })

        button.setOnClickListener {
            if (!editText.text.isEmpty()) {
                save()
            } else {
                Toast.makeText(this, "The text is empty", Toast.LENGTH_SHORT).show()
            }
            editText.text.clear()
        }
    }
    fun update(ID: Int) {
       val  intent = Intent(applicationContext, Update::class.java)
        intent.putExtra("ID",ID)
        startActivity(intent)
    }
    fun save() {
        var noteText = editText.text.toString()
        myViewModel.addNote(noteText)
        Toast.makeText(applicationContext, "data saved successfully! ", Toast.LENGTH_SHORT).show()
    }

    fun delete(id: Int, s1: String) {
        myViewModel.deleteNote(id,s1)
        Toast.makeText(applicationContext, "data deleted successfully! ", Toast.LENGTH_SHORT).show()
    }
 */