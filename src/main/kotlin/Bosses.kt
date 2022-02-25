import Level.*
import Tag.*
import DmgType.*


enum class Bosses(
    val showName: String,
    val image: String,
    val hp: Int,
    val damage: Int,
    val type: DmgType,
    val arrangement: List<Level>,
    val activeEffect: String? = null,
    val passiveEffect: String? = null,
    val isEnabled: Boolean = false
) {
    mojdodir(
        "Мойдодыр", "mojdodir.png", 40, 5, ME, listOf(B, W, W, W, W, W),
        activeEffect = "$silence на первого противника"
    )
}