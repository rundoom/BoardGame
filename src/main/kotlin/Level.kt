enum class Level { W, M, S }

enum class DmgType(val icon: String, private val tag: String) {
    ME("C", "(melee)"), RA("R", "(range)"), AO("A", "(aoe)");

    override fun toString() = tag
}

enum class HarmType(private val representation: String) {
    PAIN(Tag.harm.meaning), DISCARD(Tag.discard.meaning);

    override fun toString() = representation
}