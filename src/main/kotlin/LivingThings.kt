import Level.*
import Tag.*
import DmgType.*

//Отрава на всех
enum class LivingThings(
    val showName: String,
    val image: String,
    val level: Level,
    val hp: Int,
    val damage: Int,
    val type: DmgType,
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
        activeEffect = "$dice: 1-5:Уничтожить надетый предмет противника, если его нет нанести ${dmg(5)}<br>6: Следующий союзник получивший смертельный${dmg} не получает его"
    ),
    syringe(
        "Шприц", "syringe.png", W, 5, 1, ME,
        activeEffect = poison(1)
    ),
    flyswatter(
        "Мухобойка", "flyswatter.png", W, 2, 1, ME,
        activeEffect = stun(1)
    ),
    brick(
        "Кирпич", "brick.png", W, 4, 1, ME,
        activeEffect = arm(2)
    ),
    microwave(
        "Микроволновка", "microwave.png", W, 5, 1, ME,
        passiveEffect = "Отменить первый эффект противника"
    ),
    fridge(
        "Холодильник", "fridge.png", M, 5, 1, ME,
        "${freeze}, повторить удар в следующего противника"
    ),
    bookshelf(
        "Книжная полка", "bookshelf.png", M, 8, 0, RA,
        activeEffect = "$dice 1-4: Дать ${arm(3)} для 3х союзников<br>5-6: Повторить эффект 3х разных союзных ${weak}"
    ),
    toilet(
        "Деревенский туалет", "toilet.png", M, 5, 3, RA,
        "Нанести моим соседям ${dmg(1)}"
    ),
    giant(
        "", "", S, 15, 1, AO,
        "На меня не действуют никакие эффекты кроме урона"
    ),
    bow(
        "Лук", "bow.png", W, 2, 0, RA,
        dmg("(номер позиции)")
    ),
    hydrant(
        "Гидрант", "", M, 4, 1, RA,
        "$stun врагу и перезарядить союзника"
    ),
    needlebed(
        "Игольница", "needlebed.png", W, 1, 1, AO
    ),
    hellhound(
        "", "", M, 9, 0, ME,
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