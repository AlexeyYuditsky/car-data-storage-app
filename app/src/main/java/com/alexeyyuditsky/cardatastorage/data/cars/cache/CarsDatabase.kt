package com.alexeyyuditsky.cardatastorage.data.cars.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [CarDb::class]
)
abstract class CarsDatabase : RoomDatabase() {

    abstract fun getCarsDao(): CarsDao

}