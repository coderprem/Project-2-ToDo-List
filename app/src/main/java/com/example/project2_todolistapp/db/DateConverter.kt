package com.example.project2_todolistapp.db

import androidx.room.TypeConverter
import java.util.Date

// 3. TypeConverter -> used when you want to add some custom object in your db
// which is not supported by default
class DateConverter {

    // To convert date to long -> push data into the db
    @TypeConverter
    fun fromDataToLong(date: Date): Long {
        return date.time
    }

    // To convert long date -> reading data form the db
    @TypeConverter
    fun fromLongToDate(timestamp: Long): Date {
        return Date(timestamp)
    }
}