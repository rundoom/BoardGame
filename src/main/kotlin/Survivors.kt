import Level.*
import Tag.*
import DmgType.*
import HarmType.*


//Идёт в любой бой
//"Уничтожает карту в руке",
//"Обменяйся картами в руке с любым другим игроком"

enum class Survivors(
    val showName: String,
    val image: String,
    val hp: Int,
    val harmType: HarmType = PAIN,
    val activeEffect: String? = null,
    val harmEffect: Pair<String, Int>?,
    val passiveEffect: String? = null,
    val isEnabled: Boolean = false
) {
    aootf2(
        "Сфера неба", "aootf2.png", 8,
        activeEffect = "Наносит ${dmg(1)} следующей цели кроме $AO",
        harmEffect = "Наносит ${dmg(7)}-(номер позиции) всем врагам" to 6
    ),
    bacteriakilller(
        "Бактерия убийца", "bacteriakiller.jpg", 8,
        activeEffect = "Если после нанесения $dmg у цели меньше ${hp(2)} - убивает цель",
        harmEffect = "Убивает всех существ с ${hp("<2")} включая тех что в открытых комнатах" to 7
    ),
    banana(
        "Банан", "banana.jpg", 10, DISCARD,
        activeEffect = "Восстанавлявает ${hp(2)} стоящему спереди",
        harmEffect = "Восстанавливает ${hp(4)} союзнику" to 1
    ),
//    belyash(
//        "Беляш", "belyash.png",
//        "Восстанавливает ${hp(2)}",
//        "Восстанавливает ${hp(4)}"
//    ),
//    roses(
//        "Букет роз", "roses.jpg",
//        "Восстанавливает ${hp(3)} любому игроку",
//        "${dmg(1)} всем монстрам"
//    ),
    doublebarrel(
        "Двустволка", "doublebarrel.png", 5,
        activeEffect = "При $ME наносит урон следующей цели",
        harmEffect = "Нанести свой $dmg двум врагам" to 3
    ),
    doping(
        "Допинг", "doping.png", 6,
        activeEffect = "+${dmg(1)} ко всем атакам в ходу, ${harm(2)}",
        harmEffect = "+${dmg(3)} ко всем атакам в раунде любой цели" to 4
    ),
//    drone(
//        "Дрон", "drone.jpg",
//        "${dmg(1)}(1)",
//        "${dmg(1)} всем монстрам"
//    ),
    jew(
        "Еврейские связи", "jew.jpg", 5,
        harmEffect = "Заставить другого игрока драться вместо тебя, вы получаете все награды за бой" to 5
    ),
    lure(
        "Приманка", "lure.png", 7,
        activeEffect = "Заставляет $weak ударить одного $medi",
        harmEffect = "Заставляет $medi ударить одного $strong" to 2
    ),
    wishstone(
        "Камень желаний", "wishstone.jpg", 6,
        activeEffect = "${dmg(1)} по всем $weak",
        harmEffect = "Выкидывается заменяется на другого человека, которого можно сразу пустить в бой" to 0
    ),
    kamikazeclown(
        "Клоун-камикадзе", "kamikazeclown.png", 4,
        activeEffect = "Восстанавливает ${hp(2)}",
        harmEffect = "Убивает врага" to 4
    ),
    horse(
        "Конь", "horse.jpg", 6, DISCARD,
        passiveEffect = "$ME работает как $RA для меня",
        harmEffect = "Убивает (1), завершает бой" to 3
    ),
//    shovel(
//        "Лопата", "shovel.jpg",
//        "Нанести ${dmg(1)}",
//        "Убивает (1), игрок теряет ${hp(3)}"
//    ),
    mixer(
        "Миксер", "mixer.jpg", 5,
        activeEffect = "${dmg("+2")} для $ME, Получить ${arm(3)}",
        harmEffect = "${dmg(2)} всем врагам" to 3
    ),
    mutagenicwaste(
        "Мутагенные отходы", "mutagenicwaste.png", 4,
        passiveEffect = "Враги наносят -${dmg(1)}",
        harmEffect = "Все враги теряют половину${hp}" to 4
    ),
    knife(
        "Нож", "knife.jpg", 5,
        activeEffect = "${dmg(1)} любому $weak",
        harmEffect = "Выбери игрока, он использует $doe всех надетых предметов против выбранного врага" to 4
    ),
    nunchaku(
        "Нунчаки", "nunchaku.png", 7,
        activeEffect = "${dmg(1)} всем врагам, ${harm(1)}",
        harmEffect = "${dmg(2)} всем врагам" to 5
    ),
    screwdriver(
        "Отвёртка", "screwdriver.png", 5,
        activeEffect = "Если $ME получаю ${dmg("+1")}",
        harmEffect = "Нанести мой ${dmg("x2")} себе и любой цели" to 0
    ),
    glasses(
        "Очки", "glasses.jpg", 8, DISCARD,
        passiveEffect = "Можно выбрать эффект всех монстров",
        harmEffect = "Воостановить ${hp("$dice")}" to 1
    ),
    pepperspray(
        "Перцовый баллончик", "pepperspray.jpg", 5,
        activeEffect = "$silence",
        harmEffect = "$silence всем на любой стороне" to 3
    ),
    hourglass(
        "Песочные часы", "hourglass.jpg", 6,
        harmEffect = "Переставить врагов в любом порядке" to 2
    ),
    luckykiss(
        "Поцелуй удачи", "luckykiss.jpg", 7, DISCARD,
        activeEffect = "$dice: 1-3: 1 урон $strong и ${medi}; 4-5: ${dmg("+1")};" +
                " 6: ${dmg(3)} ${strong}, ${dmg(2)} по ${medi}, ${dmg(1)} по ${weak}",
        harmEffect = "${dmg(1)} всем врагам, восстанавливает ${hp(4)}" to 2
    ),
//    cannon(
//        "Пушка", "cannon.png",
//        "Наносит ${dmg(2)}(1)и(2)",
//        "Наносит ${dmg(5)}(1)и(2)"
//    ),
    painshare(
        "Разделитель боли", "painshare.jpg", 6,
        activeEffect = "Вы с целью делите весь полученный $dmg на двоих в этом раунде",
        harmEffect = "Выбранный игрок или монстр получает ${dmg("x2")} в этом раунде" to 4
    ),
    ecstasy(
        "Таблетка экстази", "ecstasy.jpg", 4,
        activeEffect = "Все союзники восстанавливают ${hp(1)} ${harm(1)}",
        harmEffect = "$silence всем на любой стороне, восстанавливает ${hp(2)} союзнику" to 2
    ),
    tumbler(
        "Тумблер", "tumbler.jpg", 6,
        harmEffect = "Перевернуть кубик как хочешь" to 2
    ),
    oneshotcannon(
        "Пушка-ваншотка", "oneshotcannon.png", 8,
        activeEffect = harm(1),
        harmEffect = "Нанести ${dmg("Потерянные $hp х2")}" to 2
    ),
    tinfoilhat(
        "Шапка из фольги", "tinfoilhat.png", 6,
        activeEffect = arm(1),
        harmEffect = "$silence комнате и всем ожившим вещам в ней навсегда" to 5
    ),
    armor(
        "Армор", "armor.png", 6,
        activeEffect = "Дает ${arm(1)}",
        passiveEffect = "Уменьшает весь $dmg по мне на 1",
        harmEffect = arm(5) to 3
    ),
    spikedarmor(
        "Колючий доспех", "spikedarmor.png", 6,
        activeEffect = arm(1),
        harmEffect = "${dmg(5)} любой цели" to 3,
        passiveEffect = spike("Половину нанесённого $dmg")
    ),
    iceshard(
        "Сосулька", "iceshard.png", 4,
        activeEffect = "$freeze кроме $AO",
        harmEffect = "${dmg(5)} любой цели и замораживает всех на любой стороне" to 3
    ),
    brawl(
        "Потасовка", "brawl.png", 5,
        activeEffect = "Перемещает цель на любую позицию",
        harmEffect = "Перемешивает всех на любой стороне и убитвает случайного" to 5
    ),
//    wryyyyy(
//        "Wryyyyy", "wryyyyy.png",
//        "Наносит ${dmg(5)}",
//        "Убивает любого монстра, игрок теряет (5)"
//    ),
    cucumbers(
        "Грядка огурцов", "cucumbers.png", 6,
        activeEffect = "Сбросить карту с руки чтобы уменьшить ${dmg} всех врагов на 1, восстанавливает ${hp(2)}",
        harmEffect = "Вытягиваем человека и $weak" to 4
    ),
    blizzard(
        "Снежная буря", "blizzard.png", 5,
        activeEffect = "$silence кроме $AO",
        harmEffect = "$silence всем на любой стороне, самый повреждённый умирает" to 4
    ),
    changer(
        "Менялка", "changer.png", 5,
        activeEffect = "Выкинь карту из руки, замени на карту того-же типа ${harm(1)}",
        harmEffect = "Взять человека" to 4
    ),
    russianrulette(
        "Русская рулетка", "russianrulette.png", 6,
        activeEffect = "$dice $dmg цели ${harm(2)}",
        harmEffect = "Загадайте число и бросьте $dice за себя и за цель тот у кого выпало это число - умирает" to 0
    ),
    gasstation(
        "Газовая станция", "gasstation.png", 6,
        harmEffect = "Перезарядка двух любых целей" to 3
    ),
    rug(
        "Плед", "rug.png", 7, DISCARD,
        harmEffect = "Защищает от 1 удара" to 1
    ),
    emovdv(
        "Эмо-ВДВшник", "emovdv.png", 9,
        activeEffect = "$dice: 1-4: нанести выпавшее число цели в качестве $dmg 5-6: нанести выпавшее число себе в качестве $dmg",
        harmEffect = "Наносит $dice${dmg} любой цели и $dice${dmg("+1")} себе" to 0
    ),
    pupa(
        "Пупа", "pupa.png", 8,
        activeEffect = "цель получает ${dmg(2)} кроме $AO и получить ${arm(1)}",
        passiveEffect = "Если в бою есть Лупа, я получаю урон за Лупу",
        harmEffect = "${dmg(5)} любой цели" to 5
    ),
    lupa(
        "Лупа", "lupa.png", 8,
        activeEffect = "цель получает ${dmg(1)} кроме $AO и получить ${arm(2)}",
        passiveEffect = "Если в бою есть Пупа, этот я получаю урон за Пупу",
        harmEffect = "${arm(5)} любой цели" to 3
    ),
}