package domain.model

data class ExerciseUIModel(
    val id : String = "",
    val name : String = "",
    val mediaUrl : String= "",
    val bodyPart : String = "",
    val instructions : List<String> = emptyList(),
)
