import Level.*
import Tag.*


enum class Locations(
    val showName: String,
    val image: String,
    val passiveEffect: String,
    val arrangement: List<Level>
) {
    cursedchurch(
        "Пролклятая церковь", "cursedchurch.png",
        "Монстры наносят ${dmg("+1")}",
        listOf(W,W,W,M)
    )
}