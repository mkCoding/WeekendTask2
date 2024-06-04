package com.example.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson


@Database(
    entities = [
        TrackEntity::class
    ],
    version = 2,
    exportSchema = false
)

@TypeConverters(TrackConverters::class)
abstract class TrackDatabase : RoomDatabase() {

    abstract fun trackDao(): TrackDao
}





class TrackConverters {

    @TypeConverter
    fun listToJsonString(value: List<Int?>?): String? = Gson().toJson(value)
    @TypeConverter
    fun jsonStringToList(value: String?) =
        Gson().fromJson(value, Array<Int?>::class.java).toList()
}