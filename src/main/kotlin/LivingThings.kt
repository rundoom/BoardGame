import Level.*
import Tag.*
import DmgType.*


enum class LivingThings(
    val showName: String,
    val image: String,
    val level: Level,
    val hp: Int,
    val damage: Int,    val type: DmgType,
    val activeEffect: String? = null,
    val passiveEffect: String? = null,
    val isEnabled: Boolean = false
) {
    closet(
        "Шкаф", "closet.png", M, 6, 1, ME,
        passiveEffect = spike(1)
    ),
    pulverizer(
        "Пульверизатор", "pulverizer.png", W, 4, 0, ME,
        activeEffect = "${dmg(4)}-(номер позиции)"
    ),
    toolbox(
        "Ящик инструментов", "toolbox.png", M, 7, 0, RA,
        activeEffect = "$dice: 1-3: Нанести ${dmg(3)}\n4-6: Вылечить самого повреждённого союзника на ${hp(3)}"
    ),
    barrel(
        "Бочка", "barrel.png", M, 9, 2, ME,
        activeEffect = "${dmg("(номер позиции)")}, переметиться на (1)"
    ),
    archangel(
        "", "", S, 12, 2, ME,
        activeEffect = "$dice: 1-5:Уничтожить надетый предмет противника <br>6: Следующий союзник получивший смертельный${dmg} не получает его"
    ),
    pikeman(
        "", "", W, 5, 1, ME,
        activeEffect = poison(1)
    ),
    gremlin(
        "", "", W, 2, 1, ME,
        activeEffect = stun(1)
    ),
    stonegargoyle(
        "", "", W, 4, 1, ME,
        activeEffect = arm(2)
    ),
    stonegolem(
        "", "", W, 6, 1, ME,
        passiveEffect = "Отменить первый эффект противника"
    ),
    archmage(
        "", "", M, 5, 1, ME,
        "${freeze}, повторить удар в следующего противника"
    ),
    genie(
        "", "", M, 8, 0, RA,
        activeEffect = "$dice 1-4: Дать ${arm(3)} для 3х союзников<br>5-6: Повторить эффект 3х разных союзных ${weak}"
    ),
    naga(
        "", "", M, 5, 3, RA,
        "Нанести моим соседям ${dmg(1)}"
    ),
    giant(
        "", "", S, 15, 1, AO,
        "На меня не действуют никакие эффекты кроме урона"
    ),
    archer(
        "", "", W, 2, 0, RA,
        dmg("(номер позиции)")
    ),
    imp(
        "", "", M, 4, 1, RA,
        "$stun врагу и перезарядить союзника"
    ),
    gog(
        "", "", W, 1, 1, AO
    ),
    hellhound(
        " ", "", W, 5, 0, ME,
        activeEffect = "$dice 1-3: Нанести ${dmg("Количество полученного урона")}<br> 4-6: Нанести себе ${dmg(1)}"
    ),
    demon(
        "", "", W, 4, 0, ME,
        activeEffect = poison(1)
    ),
    pitfiend(
        " ", "", M, 8, 1, RA,
        activeEffect = "Исцелить самого повреждённого союзника на ${hp(2)}",
        passiveEffect = "После смерти оставляет на своём месте $weak"
    ),
    efreetsultan(
        "", "", M, 8, 2, ME,
        passiveEffect = spike(2)
    ),
    archdevil(
        "", "", S, 15, 5, ME,
        passiveEffect = "${spike(2)}<br>Когда союзник получает $dmg, вместо этого нанести этот $dmg мне"
    ),
    kitty(
        "", "", W, 3, 3, AO,
        activeEffect = "${dmg(3)} мне"
    ),
    drought(
        "", "", M, 5, 1, RA,
        passiveEffect = "У врагов ${dmg(-1)}"
    ),
    princesskiller(
        "", "", S, 10, 3, RA,
        activeEffect = "Призвать $weak впереди себя"
    ),
    oneshotmosquito(
        " ", "", M, 2, 9, RA,
        activeEffect = "Нанести ${dmg(5)} себе"
    ),
    maniac(
        "", "", S, 10, 2, AO,
        passiveEffect = "$mad"
    ),
    deepterror(
        "", "", S, 9, 4, ME,
        activeEffect = "${dmg(-1)} цели",
        passiveEffect = "Игнорирует $arm"
    ),
    gypsy(
        "", "", S, 12, 0, RA,
        activeEffect = dmg(dice.toString())
    ),
    curse(
        "", "", S, 5, 0, RA,
        activeEffect = "Получает ${arm(2)}",
        passiveEffect = "Выкладывается на последнюю позицию<br> наносит ${dmg(1)} врагам совершающим $doe"
    ),
    lavamonster(
        "", "", W, 4, 2, ME,
        passiveEffect = "Уничтожить меня вместо $harm союзника"
    ),
    multihanded(
        "", "", M, 5, 0, AO,
        activeEffect = "${dmg(2)} всем вражеским людям даже вне боя, ухожу на дно колоды"
    ),
    crabgirl(
        "", "", S, 9, 0, RA,
        activeEffect = dmg("количество монстров на столе")
    ),
    bro(
        "", "", M, 6, 1, RA,
        activeEffect = "Уничтожить вражеского $strong чтобы уничтожить меня",
        passiveEffect = "${dmg("+1")} союзникам слева и справа от себя"
    ),
    octopus(
        "", "", M, 8, 2, RA,
        activeEffect = "${dmg(1)} соседям цели"
    ),
}