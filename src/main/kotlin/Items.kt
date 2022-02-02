import Level.*
import Tag.*


enum class Items(
    val showName: String,
    val image: String,
    val activeEffect: String,
    val handEffect: String,
    val passiveEffect: String? = null
) {
    aootf2(
        "Сфера неба", "aootf2.png",
        "Наносит ${dmg}2 (1) и ${dmg}1 (2)",
        "Наносит ${dmg}7-(номер позиции) всем монстрам"
    )
}