package di

import database.getAppDatabase
import local.AppDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single<AppDatabase> { getAppDatabase() }
    }
}