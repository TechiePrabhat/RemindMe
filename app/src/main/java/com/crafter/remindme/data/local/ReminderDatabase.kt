package com.crafter.remindme.data.local

import androidx.room.Database
import com.crafter.remindme.data.dto.Reminder


@Database(entities = [Reminder::class], version = 1)
abstract class ReminderDatabase {
 abstract fun reminderDao():ReminderDao
}