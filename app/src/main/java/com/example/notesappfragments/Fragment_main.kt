package com.example.notesappfragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment_main : Fragment() {
    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var myRv: RecyclerView
    lateinit var lv: List<Note>
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        // Decleare sharedPreferences
        sharedPreferences = requireActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE)

        editText = view.findViewById<EditText>(R.id.editText)
        button = view.findViewById<Button>(R.id.button)
        myRv = view.findViewById<RecyclerView>(R.id.recyclerView)

        lv = arrayListOf()
        NoteDatabase.getInstance(requireContext())

        myViewModel.getNotes().observe(viewLifecycleOwner, { notes -> //Rv.update(notes)
            myRv.adapter = RecyclerViewAdapter(this, notes)
            myRv.layoutManager = LinearLayoutManager(requireContext())
        })

        button.setOnClickListener {
            if (!editText.text.isEmpty()) {
                save()
            } else {
                Toast.makeText(requireContext(), "The text is empty", Toast.LENGTH_SHORT).show()
            }
            editText.text.clear()
        }
        return view
    }

    fun save() {
        var noteText = editText.text.toString()
        myViewModel.addNote(noteText)
        Toast.makeText(requireContext(), "data saved successfully! ", Toast.LENGTH_SHORT).show()
    }

    fun delete(id: Int, s1: String) {
        myViewModel.deleteNote(id, s1)
        Toast.makeText(requireContext(), "data deleted successfully! ", Toast.LENGTH_SHORT).show()
    }

}