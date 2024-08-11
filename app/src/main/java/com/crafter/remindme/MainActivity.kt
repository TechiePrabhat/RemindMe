package com.crafter.remindme

import android.os.Bundle
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.crafter.remindme.data.dto.Reminder
import com.crafter.remindme.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var reminderAdapter:ReminderAdapter
    private var reminderList:ArrayList<Reminder> =ArrayList<Reminder>()
    override fun onCreate(savedInstanceState: Bundle?) {
       enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        // UI binding
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view  =binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.updatePadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            WindowInsetsCompat.CONSUMED
        }
        /*ViewCompat.setOnApplyWindowInsetsListener(binding.heading) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.displayCutout())
            v.updateLayoutParams<MarginLayoutParams> {
                topMargin=systemBars.top
            }
            WindowInsetsCompat.CONSUMED
        }*/


        for (i in 1..12){
            reminderList.add(Reminder(
                "Kiss to moto","Every",1.0,i
            ))
        }

        reminderAdapter=ReminderAdapter(reminderList)

        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=reminderAdapter

     //   binding.heading.text="This is run time text."
    }
}