package com.example.notesappfragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController


class fragment_update : Fragment() {
    lateinit var updateText: EditText
    lateinit var updateBtn: Button
    private val myViewModel by lazy { ViewModelProvider(this).get(MyViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        // decleare shared Preferences
        val sharedPreferences = requireActivity().getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        updateBtn = view.findViewById(R.id.updateBtn)
        updateText = view.findViewById(R.id.updateText)
        updateBtn.setOnClickListener {
            if (updateText.text.isEmpty()) {
                Toast.makeText(requireContext(), "Fill all filed please!! ", Toast.LENGTH_SHORT)
                        .show()
            } else {
                // retrieve id from sharedPreferences
                val ID = sharedPreferences.getInt("ID", 0)
                myViewModel.updateNote(ID,updateText.text.toString())
                //nav to main fragment
                findNavController().navigate(R.id.action_fragment_update_to_fragment_main)
                Toast.makeText(
                        requireContext(),
                        "data updated successfully! ",
                        Toast.LENGTH_SHORT
                ).show()
            }
        }
        return view
    }

}