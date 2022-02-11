import Level.*
import Tag.*
import DmgType.*


//handEffect = "При ${doe}: Получить ${arm(1)} либо нанести ${dmg(1)} либо восстановить ${hp(1)}"
enum class LivingThings(
    val showName: String,
    val image: String,
    val level: Level,
    val hp: Int,
    val damage: Int,
    val type: DmgType,
    val activeEffect: String? = null,
    val passiveEffect: String? = null,
    val handEffect: String = "",
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
        activeEffect = "$dice: 1-5:Уничтожить надетый предмет противника <br>6: ${revive(1)} на самого хилого союзника"
    ),
    pikeman(
        "Копейщик", "pikeman.gif", W, 5, 1, ME,
        activeEffect = poison(1)
    ),
    gremlin(
        "Гремлин", "gremlin.gif", W, 2, 1, ME,
        activeEffect = stun(1)
    ),
    stonegargoyle(
        "Гаргулья", "stonegargoyle.gif", W, 4, 1, ME,
        activeEffect = arm(2)
    ),
    stonegolem(
        "Каменный голем", "stonegolem.gif", W, 6, 1, ME,
        passiveEffect = "Отменить первый эффект противника"
    ),
    archmage(
        "Холодильник", "", M, 5, 1, ME,
        "${freeze}, повторить удар в следующего противника"
    ),
    genie(
        "Джин", "genie.gif", M, 8, 0, RA,
        activeEffect = "$dice 1-4: Дать ${arm(3)} для 3х союзников<br>5-6: Повторить эффект 3х разных союзных ${weak}"
    ),
    naga(
        "Нага", "naga.gif", M, 5, 3, RA,
        "Нанести моим соседям ${dmg(1)}"
    ),
    giant(
        "Гигант", "giant.gif", S, 15, 1, AO,
        "На меня не действуют никакие эффекты кроме урона"
    ),
    archer(
        "Лучник", "archer.gif", W, 2, 0, RA,
        dmg("(номер позиции)")
    ),
    imp(
        "Бес", "imp.gif", M, 4, 1, RA,
        "$stun врагу и перезарядить союзника"
    ),
    gog(
        "Чёрт", "gog.gif", W, 1, 1, AO
    ),
    hellhound(
        "Адский пёс", "hellhound.gif", W, 5, 0, ME,
        activeEffect = "$dice 1-3: Нанести ${dmg("Количество полученного урона")}<br> 4-6: Нанести себе ${dmg(1)}"
    ),
    demon(
        "Демон", "demon.gif", W, 4, 0, ME,
        activeEffect = poison(1)
    ),
    pitfiend(
        "Обитатель бездны", "pitfiend.gif", M, 8, 1, RA,
        activeEffect = "Исцелить самого повреждённого союзника на ${hp(2)}",
        passiveEffect = "После смерти оставляет на своём месте $weak"
    ),
    efreetsultan(
        "Ифрит", "efreetsultan.gif", M, 8, 2, ME,
        passiveEffect = spike(2)
    ),
    archdevil(
        "Дьявол", "archdevil.gif", S, 15, 5, ME,
        passiveEffect = "${spike(2)}<br>Когда союзник получает $dmg, вместо этого нанести этот $dmg мне"
    ),
    kitty(
        "Киска", "kitty.png", W, 3, 3, AO,
        activeEffect =  "${dmg(3)} мне"
    ),
    drought(
        "Сушняк", "drought.png", M, 5, 1, RA,
        passiveEffect = "У врагов ${dmg(-1)}"
    ),
    princesskiller(
        "Принцесса-убийца", "princesskiller.png", S, 10, 3, RA,
        activeEffect = "Призвать $weak впереди себя"
    ),
    oneshotmosquito(
        "Ваншотящий комар", "oneshotmosquito.png", M, 2, 9, RA,
        activeEffect = "Нанести ${dmg(5)} себе"
    ),
    maniac(
        "Маньяк", "maniac.png", S, 10, 2, AO,
        passiveEffect = "$mad"
    ),
    deepterror(
        "Ужас глубин", "deepterror.png", S, 9, 4, ME,
        activeEffect = "${dmg(-1)} цели",
        passiveEffect ="Игнорирует $arm"
    ),
    gypsy(
        "Гадалка", "gypsy.png", S, 12, 0, RA,
        activeEffect = dmg(dice.toString())
    ),
    curse(
        "Проклятье", "curse.png", S, 5, 0, RA,
        activeEffect = "Получает ${arm(2)}",
        passiveEffect = "Выкладывается на последнюю позицию<br> наносит ${dmg(1)} врагам совершающим $doe"
    ),
    lavamonster(
        "Лава монстр", "lavamonster.png", W, 4, 2, ME,
        passiveEffect = "Уничтожить меня вместо $harm союзника"
    ),
    multihanded(
        "Многорукий многоног", "multihanded.png", M, 5, 0, AO,
        activeEffect = "${dmg(2)} всем вражеским людям даже вне боя, ухожу на дно колоды"
    ),
    crabgirl(
        "Девочка краб", "crabgirl.png", S, 9, 0, RA,
        activeEffect = dmg("количество монстров на столе")
    ),
    bro(
        "Братан", "bro.png", M, 6, 1, RA,
        activeEffect =  "Уничтожить вражеского $strong чтобы уничтожить меня",
        passiveEffect = "${dmg("+1")} союзникам слева и справа от себя"
    ),
    octopus(
        "Осьминог", "octopus.png", M, 8, 2, RA,
        activeEffect = "${dmg(1)} соседям цели"
    ),
}