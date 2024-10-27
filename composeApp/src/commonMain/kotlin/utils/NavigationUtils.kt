package utils

import kotlinx.serialization.Serializable

@Serializable
object HomeHost

@Serializable
object HomeRoute

@Serializable
object ProgramHost

@Serializable
object ProgramRoute

@Serializable
data class ProgramDetailRoute(val dayId: Int)

