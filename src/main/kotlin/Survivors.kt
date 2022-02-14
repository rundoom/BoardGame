import DmgType.*
import HarmType.DISCARD
import HarmType.PAIN
import Tag.*


//Идёт в любой бой
//"Уничтожает карту в руке",
//"Обменяйся картами в руке с любым другим игроком"

enum class Survivors(
    val showName: String,
    val image: String,
    val hp: Int,
    val harmType: HarmType = PAIN,
    val activeEffect: String? = null,
    val harmEffect: Pair<String, Int>,
    val passiveEffect: String? = null,
    val isEnabled: Boolean = false
) {
    aootf2(
        "Сфера неба", "", 8,
        activeEffect = "Наносит ${dmg(1)} следующей цели кроме $AO",
        harmEffect = "Наносит ${dmg(7)}-(номер позиции) всем врагам" to 6
    ),
    bacteriakilller(
        "Бактерия убийца", "", 8,
        activeEffect = "Если после нанесения $dmg у цели меньше ${hp(2)} - убивает цель",
        harmEffect = "Убивает всех существ с ${hp("<2")} включая тех что в открытых комнатах" to 7
    ),
    banana(
        "Банан", "", 10, DISCARD,
        activeEffect = "Восстанавлявает ${hp(2)} стоящему спереди",
        harmEffect = "Восстанавливает ${hp(4)} союзнику" to 1
    ),
    doublebarrel(
        "Двустволка", "", 5,
        activeEffect = "При $ME наносит урон следующей цели",
        harmEffect = "Нанести свой $dmg двум врагам" to 3
    ),
    doping(
        "Допинг", "", 6,
        activeEffect = "+${dmg(1)} ко всем атакам в ходу, ${harm(2)}",
        harmEffect = "+${dmg(3)} ко всем атакам в раунде любой цели" to 4
    ),
    jew(
        "Еврейские связи", "", 5,
        harmEffect = "Заставить другого игрока драться вместо тебя, вы получаете все награды за бой" to 5
    ),
    lure(
        "Приманка", "", 7,
        activeEffect = "Заставляет $weak ударить одного $medi",
        harmEffect = "Заставляет $medi ударить одного $strong" to 2
    ),
    wishstone(
        "Камень желаний", "", 6,
        activeEffect = "${dmg(1)} по всем $weak",
        harmEffect = "Выкидывается заменяется на другого человека, которого можно сразу пустить в бой" to 0
    ),
    kamikazeclown(
        "Клоун-камикадзе", "", 4,
        activeEffect = "Восстанавливает ${hp(2)}",
        harmEffect = "Убивает врага" to 4
    ),
    horse(
        "Конь", "", 6, DISCARD,
        passiveEffect = "$ME работает как $RA для меня",
        harmEffect = "Убивает (1), завершает бой" to 3
    ),
    mixer(
        "Миксер", "", 5,
        activeEffect = "${dmg("+2")} для $ME, Получить ${arm(3)}",
        harmEffect = "${dmg(2)} всем врагам" to 3
    ),
    mutagenicwaste(
        "Мутагенные отходы", "", 4,
        passiveEffect = "Враги наносят -${dmg(1)}",
        harmEffect = "Все враги теряют половину${hp}" to 4
    ),
    knife(
        "Нож", "", 5,
        activeEffect = "${dmg(1)} любому $weak",
        harmEffect = "Выбери игрока, он использует $doe всех надетых предметов против выбранного врага" to 4
    ),
    nunchaku(
        "Нунчаки", "", 7,
        activeEffect = "${dmg(1)} всем врагам, ${harm(1)}",
        harmEffect = "${dmg(2)} всем врагам" to 5
    ),
    screwdriver(
        "Отвёртка", "", 5,
        activeEffect = "Если $ME получаю ${dmg("+1")}",
        harmEffect = "Нанести мой ${dmg("x2")} себе и любой цели" to 0
    ),
    glasses(
        "Очки", "", 8, DISCARD,
        passiveEffect = "Можно выбрать эффект всех монстров",
        harmEffect = "Воостановить ${hp("$dice")}" to 1
    ),
    pepperspray(
        "Перцовый баллончик", "", 5,
        activeEffect = "$silence",
        harmEffect = "$silence всем на любой стороне" to 3
    ),
    hourglass(
        "Песочные часы", "", 6,
        harmEffect = "Переставить врагов в любом порядке" to 2
    ),
    luckykiss(
        "Поцелуй удачи", "", 7, DISCARD,
        activeEffect = "$dice: 1-3: 1 урон $strong и ${medi}; 4-5: ${dmg("+1")};" +
                " 6: ${dmg(3)} ${strong}, ${dmg(2)} по ${medi}, ${dmg(1)} по ${weak}",
        harmEffect = "${dmg(1)} всем врагам, восстанавливает ${hp(4)}" to 2
    ),
    painshare(
        "Разделитель боли", "", 6,
        activeEffect = "Вы с целью делите весь полученный $dmg на двоих в этом раунде",
        harmEffect = "Выбранный игрок или монстр получает ${dmg("x2")} в этом раунде" to 4
    ),
    ecstasy(
        "Таблетка экстази", "", 4,
        activeEffect = "Все союзники восстанавливают ${hp(1)} ${harm(1)}",
        harmEffect = "$silence всем на любой стороне, восстанавливает ${hp(2)} союзнику" to 2
    ),
    tumbler(
        "Тумблер", "", 6,
        harmEffect = "Перевернуть кубик как хочешь" to 2
    ),
    oneshotcannon(
        "Пушка-ваншотка", "", 8,
        activeEffect = harm(1),
        harmEffect = "Нанести ${dmg("Потерянные $hp х2")}" to 2
    ),
    tinfoilhat(
        "Шапка из фольги", "", 6,
        activeEffect = arm(1),
        harmEffect = "$silence комнате и всем ожившим вещам в ней навсегда" to 5
    ),
    armor(
        "Армор", "", 6,
        activeEffect = "Дает ${arm(1)}",
        passiveEffect = "Уменьшает весь $dmg по мне на 1",
        harmEffect = arm(5) to 3
    ),
    spikedarmor(
        "Колючий доспех", "", 6,
        activeEffect = arm(1),
        harmEffect = "${dmg(5)} любой цели" to 3,
        passiveEffect = spike("Половину нанесённого $dmg")
    ),
    iceshard(
        "Сосулька", "", 4,
        activeEffect = "$freeze кроме $AO",
        harmEffect = "${dmg(5)} любой цели и замораживает всех на любой стороне" to 3
    ),
    brawl(
        "Потасовка", "", 5,
        activeEffect = "Перемещает цель на любую позицию",
        harmEffect = "Перемешивает всех на любой стороне и убитвает случайного" to 5
    ),
    cucumbers(
        "Грядка огурцов", "", 6,
        activeEffect = "Сбросить карту с руки чтобы уменьшить ${dmg} всех врагов на 1, восстанавливает ${hp(2)}",
        harmEffect = "Вытягиваем человека и $weak" to 4
    ),
    blizzard(
        "Снежная буря", "", 5,
        activeEffect = "$silence кроме $AO",
        harmEffect = "$silence всем на любой стороне, самый повреждённый умирает" to 4
    ),
    changer(
        "Менялка", "", 5,
        activeEffect = "Выкинь карту из руки, замени на карту того-же типа ${harm(1)}",
        harmEffect = "Взять человека" to 4
    ),
    russianrulette(
        "Русская рулетка", "", 6,
        activeEffect = "$dice $dmg цели ${harm(2)}",
        harmEffect = "Загадайте число и бросьте $dice за себя и за цель тот у кого выпало это число - умирает" to 0
    ),
    gasstation(
        "Газовая станция", "", 6,
        harmEffect = "Перезарядка двух любых целей" to 3
    ),
    rug(
        "Плед", "", 7, DISCARD,
        harmEffect = "Защищает от 1 удара" to 1
    ),
    emovdv(
        "Эмо-ВДВшник", "", 9,
        activeEffect = "$dice: 1-4: нанести выпавшее число цели в качестве $dmg 5-6: нанести выпавшее число себе в качестве $dmg",
        harmEffect = "Наносит $dice${dmg} любой цели и $dice${dmg("+1")} себе" to 0
    ),
    pupa(
        "Пупа", "", 8,
        activeEffect = "цель получает ${dmg(2)} кроме $AO и получить ${arm(1)}",
        passiveEffect = "Если в бою есть Лупа, я получаю урон за Лупу",
        harmEffect = "${dmg(5)} любой цели" to 5
    ),
    lupa(
        "Лупа", "", 8,
        activeEffect = "цель получает ${dmg(1)} кроме $AO и получить ${arm(2)}",
        passiveEffect = "Если в бою есть Пупа, этот я получаю урон за Пупу",
        harmEffect = "${arm(5)} любой цели" to 3
    ),
}