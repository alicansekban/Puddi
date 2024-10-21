package database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.local.AppDatabase


fun getAppDatabase(context: Context): AppDatabase {
    val dbFile = context.getDatabasePath("app.db")
    return Room.databaseBuilder<AppDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    ).setDriver(BundledSQLiteDriver())
        .build()
}