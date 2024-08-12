package com.crafter.remindme.ui.component.reminderList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crafter.remindme.data.dto.Reminder
import com.crafter.remindme.databinding.ItemListReminderBinding

class ReminderAdapter(dataList:List<Reminder>): RecyclerView.Adapter<ReminderAdapter.MyViewHolder>() {
    private val reminderList:List<Reminder> =dataList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding=ItemListReminderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  data =reminderList.get(position)
        holder.bind(data)
    }

    override fun getItemCount(): Int {
       return reminderList.size
    }

    inner class MyViewHolder(private val binding:ItemListReminderBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(reminder: Reminder){
            binding.reminder =reminder
        }
    }
}

