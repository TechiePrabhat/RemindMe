package com.crafter.remindme.ui.component.reminderList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.crafter.remindme.data.dto.Reminder
import com.crafter.remindme.databinding.FragmentReminderListBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class ReminderListFragment : Fragment() {
    private lateinit var binding: FragmentReminderListBinding
    private lateinit var reminderAdapter: ReminderAdapter
    private var reminderList:ArrayList<Reminder> =ArrayList<Reminder>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // view binding
        binding= FragmentReminderListBinding.inflate(inflater,container,false)
        val view =binding.root

        for (i in 1..12){
            reminderList.add(Reminder(
                "Kiss to moto","Every",1.0,i
            ))
        }

        // Setting Adapter to show reminders in the list.
        reminderAdapter= ReminderAdapter(reminderList)
        binding.recyclerView.layoutManager=LinearLayoutManager(activity)
        binding.recyclerView.adapter=reminderAdapter


        // returning root view
        return view


    }
}