import Level.*
import Tag.*


enum class Creatures(
    val showName: String,
    val image: String,
    val level: Level,
    val hp: Int,
    val damage: Int,
    val activeEffect: String? = null,
    val passiveEffect: String? = null,
    val handEffect: String = "",
    val isEnabled: Boolean = false
) {
        royalgriffin(
        "Грифон", "royalgriffin.gif", W, 6, 1,
            passiveEffect = "В этом цикле игрок или монстр наносит ${dmg(1)} всем кто нанёс ${dmg} ему",
            handEffect = "При получении ${dmg} наносит ${dmg}1",
    ),
    crusader(
        "Мечник", "crusader.gif", W, 4, 0,
        "Нанести ${dmg(4)}-(номер позиции)",
        handEffect = "Отдалить или приблизить позицию монстра на 1"
    ),
    zealot(
        "Монах", "zealot.gif", M, 7, 0,
        "$dice: 1-3: Нанести ${dmg(3)}\n4-6: Вылечить самого повреждённого монстра на 3",
        handEffect = "При $doe Вылечить игрока на 1"
    ),
    champion(
        "Рыцарь", "champion.gif", M, 9, 3,
        "Нанести ${dmg("(номер позиции)")}, переметиться на (1)",
        handEffect = "Если предмет убил существо нанесите ${dmg}1 стоящему после него"
    ),
    archangel(
        "Ангел", "archangel.gif", S, 12, 2,
        "$dice: 1-5:Уничтожить карту в руке<br>6: Следующий убитый монстр воскреснет с полным хп",
        handEffect =  "Один раз за ход можно выкинуть предмет не выкидывая"
    ),
    pikeman(
        "Копейщик", "pikeman.gif", W, 5, 1,
        passiveEffect = "(1) нанести ${dmg}1"
    ),
    gremlin(
        "Гремлин", "gremlin.gif", W, 2, 1,
        "Разрядить предмет",
        handEffect = "Разрядить предмет"
    ),
    stonegargoyle(
        "Гаргулья", "stonegargoyle.gif", W, 4, 1,
        "Получить ${arm}2",
        handEffect = "Даёт ${arm}2"
    ),
    stonegolem(
        "Каменный голем", "stonegolem.gif", W, 6, 2,
        passiveEffect = "Отменить эффект $weak или предмета",
        handEffect = "Нейтрализует первый эффект в ходу направленный на него"
    ),
    archmage(
        "Маг", "archmage.gif", W, 5, 1,
        "Разрядить 2 предмета",
        handEffect = "Перезарядить 2 предмета"
    ),
    genie(
        "Джин", "genie.gif", M, 8, 1,
        "$dice 1-4: Дать ${arm}2 для 3х ${weak}<br>5-6: Повторить эффект 3х ${weak}",
        handEffect = "При ${doe}: Получить ${arm}1 либо нанести ${dmg}1 либо восстановить ${hp}1"
    ),
    naga(
        "Нага", "naga.gif", M, 8, 3,
        "Нанести соседним монстрам ${dmg(1)}",
        handEffect = "При ${doe}: Увеличивает ${dmg} на 2 и наносит ${dmg(2)} игроку"
    ),
    giant(
        "Гигант", "giant.gif", S, 15, 3,
        "${dmg(1)} остальным игрокам",
        "Не действуют эффекты ${trash} нацеленные на него",
        "Нанести ${dmg}3 монстру и ${dmg}1 остальным монстам"
    ),
    archer(
        "Лучник", "archer.gif", W, 2, 0,
        "Нанести ${dmg("(номер позиции)")} игроку",
        handEffect = "Нанести ${dmg("(номер позиции)")} монстру"
    ),
    imp(
        "Бес", "imp.gif", W, 2, 1,
        "Разрядить 1 предмет",
        handEffect = "Нанести ${dmg(1)} и зарядить 1 предмет"
    ),
    gog(
        "Чёрт", "gog.gif", W, 3, 2,
        "${dmg(1)} остальным игрокам",
        handEffect = "Нанести ${dmg(2)} монстру и ${dmg(1)} остальным монстрам"
    ),
    hellhound(
        "Адский пёс", "hellhound.gif", W, 4, 0,
        "$dice 1-3: Нанести ${dmg("Количество фишек")}, 4-6: Положить фишку на эту карту",
        handEffect = "Перенести все фишки с одной карты на другую"
    ),
    demon(
        "Демон", "demon.gif", W, 4, 0,
        "Наложить 1 отравление",
        handEffect = "Нанести игроку ${dmg("За каждую фишку под его контролем")}"
    ),
    pitfiend(
        "Обитатель бездны", "pitfiend.gif", M, 8, 1,
        "Исцелить самого повреждённого монстра на ${hp(1)}",
        "После смерти оставляет на своём месте ${weak}",
        "${dmg("+2")}, после нанесения урона исцеляет самого раненого монстра на ${hp(1)}"
    ),
    efreetsultan(
        "Ифрит", "efreetsultan.gif", M, 10, 3,
        "При получении ${dmg} наносит ${dmg(1)}",
        "При получении ${dmg} наносит ${dmg(1)} монстру который нанёс ${dmg}",
    ),
    archdevil(
        "Дьявол", "archdevil.gif", S, 15, 5,
        passiveEffect = "Первый раз в цикле когда любой монстр получает $dmg, вместо этого нанести этот $dmg дьяволу и ${dmg(2)} игроку",
        handEffect = "При нанесении $dmg монстру перенести его на любую позицию и нанести ${dmg(1)} урона соседям"
    ),
    emovdv(
        "Эмо-ВДВшник", "emovdv.png", M, 20, 0,
        "Наносит $dice${dmg} игроку и $dice${dmg("-1")} себе",
        handEffect = "При ${doe}: $dice: 1-4: нанести выпавшее число себе в качестве $dmg 5-6: нанести выпавшее число (1) монстру в качестве $dmg"
    ),
    kitty(
        "Киска", "kitty.png", W, 3, 1,
        handEffect = "${dmg(3)} всем игрокам"
    ),
    drought(
        "Сушняк", "drought.png", W, 5, 1,
        "${dmg(1)} игроку",
        "Снижает ${dmg} любого игрока на 1",
        "Снижает ${dmg} игрока на 1"
    ),
    princesskiller(
        "Принцесса-убийца", "princesskiller.png", S, 10, 5,
        "Призвать ${weak} впереди себя",
        "При активации взять ${weak} и сразу использовать"
    ),
    oneshotmosquito(
        "Ваншотящий комар", "oneshotmosquito.png", M, 4, 9,
        "Нанести игроку ${dmg(10)}",
        "При эффекте ${trash} наносит 10 урона (1)"
    ),
    pupa(
        "Пупа", "pupa.png", M, 8, 2,
        "Получить ${arm(1)}",
        "При использовании на цель нанести ${dmg(2)} цели и получить ${arm(1)}",
        "Если в бою есть Лупа, этот монстр получает урон за Лупу"
    ),
    lupa(
        "Лупа", "lupa.png", M, 8, 1,
        "Получить ${arm(2)}",
        "При использовании на цель нанести ${dmg(1)} цели и получить ${arm(2)}",
        "Если в бою есть Пупа, этот монстр получает урон за Пупу"
    ),
    maniac(
        "Маньяк", "maniac.png", S, 10, 3,
        "Наносит ${dmg(1)} всем игрокам",
        handEffect = "Можно ${doe} дважды"
    ),
    deepterror(
        "Ужас глубин", "deepterror.png", S, 9, 3,
        "Уничтожает карту в руке",
        "Игнорирует ${arm}, -1${dmg} игрока",
        "При ${doe} на цель оглушает её"
    ),
    gypsy(
        "Гадалка", "gypsy.png", S, 8, 0,
        "Нанести $dice $dmg",
        handEffect = "Дает 3 щита, можно нанести 1 урон любому игроку"
    ),
    curse(
        "Проклятье", "curse.png", S, 5, 0,
        "Получает ${arm(1)}",
        "Выкладывается на последнюю позицию, наносит ${dmg(1)} каждый раз, когда игрок совершает ${doe}",
        "При ${doe} наносит ${dmg(1)} всем монстрам"
    ),
    lavamonster(
        "Лава монстр", "lavamonster.png", W, 4, 2,
        "Наносит ${dmg(1)} остальным игрокам",
        handEffect = "Предотвращает уничтожение предмета при ${trash}"
    ),
    multihanded(
        "Многорукий многоног", "multihanded.png", M, 5, 0,
        "${dmg(2)} всем игрокам, Уходит в низ колоды монстров",
        handEffect = "При ${doe}: ${arm(1)}. Лечит ${hp(1)}. базовый ${dmg("+1")} ",
        isEnabled = true
    ),
    crabgirl(
        "Девочка краб", "crabgirl.png", S, 9, 0,
        "Наносит ${dmg} равный количеству монстров на столе",
        handEffect = "При ${doe}: ${dice} ${arm}",
        isEnabled = true
        ),
    bro(
        "Братан", "bro.png", M, 6, 1,
        passiveEffect = "${dmg("+1")} монстрам слева и справа от себя",
        handEffect = "Убить сильного монстра уничтожив слот с этой картой",
        isEnabled = true
    ),
    octopus(
        "Осьминог", "octopus.png", M, 8, 2,
        "${dmg(1)} игрокам слева и справа",
        handEffect = "Наносит ${dmg(2)} монстру справа от атакованного",
        isEnabled = true
    ),
}