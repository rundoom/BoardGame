enum class Level { W, M, S }

enum class DmgType(private val representation: String) {
    ME("C"), RA("R"), AO("A");

    override fun toString() = representation
}

enum class HarmType(private val representation: String) {
    PAIN(Tag.harm.meaning), DISCARD(Tag.discard.meaning);

    override fun toString() = representation
}