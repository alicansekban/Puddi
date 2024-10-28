package domain.mapper

import data.response.ExerciseResponseItem
import domain.model.ExerciseUIModel

fun ExerciseResponseItem.toUIModel() : ExerciseUIModel =
    ExerciseUIModel(
        id = this.id ?: "",
        name = this.name ?: "",
        mediaUrl = this.gifUrl ?: "",
        bodyPart = this.bodyPart ?: "",
        instructions = this.instructions ?: emptyList()
    )