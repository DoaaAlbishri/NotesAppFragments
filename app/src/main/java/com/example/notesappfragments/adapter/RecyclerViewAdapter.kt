package com.example.notesappfragments.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappfragments.fragment.Fragment_main
import com.example.notesappfragments.dataBase.Note
import com.example.notesappfragments.R
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(private val mainActivity: Fragment_main, private val words: List<Note>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>(){
    class ItemViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView)
    var ctx : Context? = null
   // private var words =  listOf<Note>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        ctx = parent.context
        return ItemViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_row
                        ,parent
                        ,false
                )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val word=words[position]

        holder.itemView.apply {
            tv.text = word.note
            if(position%2==0){llItem.setBackgroundColor(Color.GRAY)}
            editBtn.setOnClickListener {
                // add id to shared preferences
                with(mainActivity.sharedPreferences.edit()) {
                    putInt("ID", word.ID)
                    apply()
                }
                //nav to update fragment
                mainActivity.findNavController().navigate(R.id.action_fragment_main_to_fragment_update)
            }
            delBtn.setOnClickListener {
                mainActivity.delete(word.ID,word.note)
            }
        }
    }

    override fun getItemCount(): Int =words.size

    //fun update(notes: List<Note>){
    //    this.words = notes
    //    notifyDataSetChanged()
    //}

}