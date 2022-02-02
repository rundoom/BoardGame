enum class Tag(val meaning: String) {
    dice("(dice)"),
    doe("(do)"),
    arm("(arm)"),
    trash("(trash)"),
    weak("(weak)"),
    medi("(medi)"),
    strong("(strong)"),
    dmg("(dmg)"),
    hp("(hp)"),
    pass("(pass)");

    operator fun invoke(count: Int) = this.toString() + count
    operator fun invoke(suffix: String) = this.toString() + suffix

    override fun toString(): String {
        return meaning
    }
}