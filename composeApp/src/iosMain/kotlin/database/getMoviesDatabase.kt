package database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import data.local.AppDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask


fun getAppDatabase(): AppDatabase {
    val dbFilePath = documentDirectory() + "/app.db"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath,
    ).setDriver(BundledSQLiteDriver())
        .build()
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}