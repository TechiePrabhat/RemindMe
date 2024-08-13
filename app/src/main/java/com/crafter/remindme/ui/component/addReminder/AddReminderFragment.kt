package com.crafter.remindme.ui.component.addReminder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.crafter.remindme.R
import com.crafter.remindme.databinding.FragmentAddReminderBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddReminderFragment : Fragment() {
 private lateinit var binding:FragmentAddReminderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // View binding
        binding = FragmentAddReminderBinding.inflate(inflater)
        var view =binding.root




        return view
    }

}