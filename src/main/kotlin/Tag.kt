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
    pass("(pass)"),
    revive("(revive)"),
    poison("(poison)"),
    stun("(stun)"),
    freeze("(freeze)"),
    mad("(mad)"),
    harm("(harm)"),
    silence("(silence)"),
    spike("spike");

    operator fun invoke(count: Int) = this.toString() + count
    operator fun invoke(suffix: String) = this.toString() + suffix

    override fun toString(): String {
        return meaning
    }
}