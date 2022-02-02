import Level.*
import Tag.*


enum class Level(val hand: String) {
    W("(trash)"),
    M("(buff)"),
    S("(buff)")
}

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

enum class Creatures(
    val showName: String,
    val image: String,
    val level: Level,
    val hp: Int,
    val activeEffect: String,
    val handEffect: String,
    val passiveEffect: String? = null
) {
    royalgriffin(
        "Грифон", "royalgriffin.gif", W, 6,
        "Наносит ${dmg}1",
        "В этом цикле игрок или монстр наносит ${dmg}1 всем кто нанёс ${dmg} ему",
        "При получении ${dmg} наносит ${dmg}1",
    ),
    crusader(
        "Мечник", "crusader.gif", W, 4,
        "Нанести ${dmg}4-(номер позиции) ",
        "Отдалить или приблизить позицию монстра на 1"
    ),
    zealot(
        "Монах", "zealot.gif", M, 7,
        "$dice: 1-3: Нанести ${dmg}3\n4-6: Вылечить самого повреждённого монстра на 3",
        "При $doe Вылечить игрока на 1"
    ),
    champion(
        "Рыцарь", "champion.gif", M, 9,
        "Нанести ${dmg}3+(номер позиции), переметиться на (1)",
        "Если предмет убил существо нанесите ${dmg}1 стоящему после него"
    ),
    archangel(
        "Ангел", "archangel.gif", S, 12,
        "$dice: 1-5:Уничтожить карту в руке<br>6: Следующий убитый монстр воскреснет с полным хп",
        "Один раз за ход можно выкинуть предмет не выкидывая"
    ),
    pikeman(
        "Копейщик", "pikeman.gif", W, 5,
        "Нанести ${dmg}1",
        "(1) нанести ${dmg}1"
    ),
    gremlin(
        "Гремлин", "gremlin.gif", W, 2,
        "Разрядить предмет",
        "Разрядить предмет"
    ),
    stonegargoyle(
        "Гаргулья", "stonegargoyle.gif", W, 6,
        "Получить ${arm}2",
        "Даёт ${arm}2"
    ),
    stonegolem(
        "Каменный голем", "stonegolem.gif", W, 6,
        "Нанести ${dmg}2",
        "Отменить эффект $weak или предмета",
        "Нейтрализует первый эффект в ходу направленный на него"
    ),
    archmage(
        "Маг", "archmage.gif", W, 5,
        "Разрядить 2 предмета",
        "Перезарядить 2 предмета"
    ),
    genie(
        "Джин", "genie.gif", M, 8,
        "$dice 1-4: Дать ${arm}2 для 3х ${weak}<br>5-6: Повторить эффект 3х ${weak}",
        "При ${doe}: Получить ${arm}1 либо нанести ${dmg}1 либо восстановить ${hp}1"
    ),
    naga(
        "Нага", "naga.gif", M, 8,
        "Нанести игроку ${dmg}5 и нанести соседним монстрам ${dmg}1",
        "При ${doe}: Увеличивает ${dmg} на 2 и наносит ${dmg}2 игроку"
    ),
    giant(
        "Гигант", "giant.gif", S, 15,
        "Нанести ${dmg}3 игроку и ${dmg}1 остальным игрокам",
        "Нанести ${dmg}3 монстру и ${dmg}1 остальным монстам",
        "Не действуют эффекты ${trash} нацеленные на него"
    ),
    archer(
        "Лучник", "archer.gif", W, 2,
        "Нанести ${dmg}(номер позиции) игроку",
        "Нанести ${dmg}(номер позиции) монстру"
    )
}