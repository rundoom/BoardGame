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

    override fun toString(): String {
        return meaning
    }
}