package com.crafter.remindme.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.crafter.remindme.data.dto.Reminder


@Database(entities = [Reminder::class], version = 1)
abstract class ReminderDatabase :RoomDatabase() {
 abstract fun reminderDao():ReminderDao
}