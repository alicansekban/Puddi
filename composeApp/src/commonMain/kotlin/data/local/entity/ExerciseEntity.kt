package data.local.entity

import androidx.room.*

@Entity(tableName = "days")
data class Day(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val dayName: String // Örneğin Pazartesi, Salı...
)

@Entity(
    tableName = "exercises",
    foreignKeys = [ForeignKey(
        entity = Day::class,
        parentColumns = ["id"],
        childColumns = ["dayId"],
        onDelete = ForeignKey.CASCADE // Bir gün silinmez, fakat onunla bağlantılı exercises'lar silinebilir
    )]
)
data class Exercise(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val dayId: Int, // İlgili günün ID'si (foreign key)
    val title: String, // Örneğin egzersiz adı
    val duration: Int, // Egzersizin süresi (dakika olarak)
    val image: String // Egzersiz resmi, URI formatında olabilir
)

data class DayWithExercises(
    @Embedded val day: Day,
    @Relation(
        parentColumn = "id",
        entityColumn = "dayId"
    )
    val exercises: List<Exercise>
)