package com.crafter.remindme.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reminder(
    val tittle:String,
    val duration:String,
    val period: Double,
    @PrimaryKey val Id:Int?=null
)
