import Level.*
import Tag.*


enum class Items(
    val showName: String,
    val image: String,
    val activeEffect: String,
    val handEffect: String,
    val passiveEffect: String? = null,
    val isEnabled: Boolean = false
) {
    aootf2(
        "Сфера неба", "aootf2.png",
        "Наносит ${dmg(1)} (1) и ${dmg(1)} (2)",
        "Наносит ${dmg(7)}-(номер позиции) всем монстрам"
    ),
    bacteriakilller(
        "Бактерия убийца" , "bacteriakiller.jpg",
        "Убивает всех монстров с ${hp(1)}",
        "Убивает всех монстров с ${hp(1)} включая тех что в открытых комнатах"
    ),
    banana(
        "Банан", "banana.jpg",
        "${dmg(1)} монстру и следующим за ним",
        "Восстанавливает ${hp(2)}"
    ),
    belyash(
        "Беляш", "belyash.png",
        "Восстанавливает ${hp(1)}",
        "Восстанавливает ${hp(2)}"
    ),
    roses(
        "Букет роз", "roses.jpg",
        "Восстанавливает ${hp(3)} любому игроку",
        "${dmg(1)} всем монстрам"
    ),
    doublebarrel(
        "Двустволка", "doublebarrel.png",
        "Нанести ${dmg(1)} двум монстрам",
        "Нанести ${dmg(3)} двум монстрам"
    ),
    doping(
        "Допинг", "doping.png",
        "+${dmg(1)} ко всем атакам в цикле, получить ${dmg(1)}",
        "+${dmg(3)} ко всем атакам в цикле, получить ${dmg(3)}"
    ),
    drone(
        "Дрон", "drone.jpg",
        "${dmg(1)}(1)",
        "${dmg(1)} последнему монстру"
    ),
    jew(
        "Еврейские связи", "jew.jpg",
        "Выйти из боя",
        "Заставить другого игрока драться вместо тебя, вы получаете все награды за бой"
    ),
    lure(
        "Приманка", "lure.png",
        "Заставляет ${weak} использовать эффект против ${medi}",
        "Заставляет ${medi} использовать эффект против ${strong}"
    ),
    wishstone(
        "Камень желаний", "wishstone.jpg",
        "${dmg(1)} по ${weak}",
        "Выкидывается заменяется на другой предмет, который сразу же активен и может быть использован"
    ),
    kamikazeclown(
        "Клоун-камикадзе", "kamikazeclown.png",
        "Восстанавливает ${hp(2)}",
        "Убивает монстра"
    ),
    horse(
        "Конь", "horse.jpg",
        "Ограничения по позиции монстров не действуют в этом цикле",
        "Убивает (1), выходим из боя"
    ),
    shovel(
        "Лопата", "shovel.jpg",
        "Нанести ${dmg(1)}",
        "Убивает (1)"
    ),
    mixer(
        "Миксер", "mixer.jpg",
        "${dmg(3)}(1), Получить ${arm(3)}",
        "${dmg(2)} всем монстрам"
    ),
    mutagenicwaste(
        "Мутагенные отходы", "mutagenicwaste.png",
        "Монстры в цикле наносят -${dmg(1)}, ${dmg(1)} всем монстрам",
        "Все монстры теряют половину${hp}"
    ),
    knife(
        "Нож", "knife.jpg",
        "${dmg(1)}${weak}",
        "Выбери игрока, он использует ${doe}любых предметов против выбранного монстра"
    ),
    nunchaku(
        "Нунчаки", "nunchaku.png",
        "${dmg(1)} всем игрокам",
        "${dmg(2)} всем монстрам"
    ),
    screwdriver(
        "Отвёртка","screwdriver.png",
        "Положите жетон на предмет, нанесите (1) ${dmg("(количество жетонов)")}",
        "нанесите ${dmg("(количество жетонов * 2)")}",
        "В конце боя сбросьте жетоны"
    ),
    glasses(
        "Очки", "glasses.jpg",
        "Можно выбрать эффект всех монстров, получить ${dmg(1)}",
        "Восстанавливает $dice ${hp}"
    ),
    pepperspray(
        "Перцовый баллончик", "pepperspray.jpg",
        "На один цикл убирает эффект любого монстра",
        "На один цикл убирает эффект всех монстров"
    ),
    hourglass(
        "Песочные часы", "hourglass.jpg",
        "Переставить монстров в любом порядке",
        "Обменяйся картами в руке с любым другим игроком"
    ),
    luckykiss(
        "Поцелуй удачи", "luckykiss.jpg",
        "$dice: 1-3: 1 урон ${strong} и ${medi}; 4-5: ${dmg("+1")} от карт; 6: ${dmg(3)} ${strong}, ${dmg(2)} по ${medi}, ${dmg(1)} по ${weak}",
        "${dmg(1)} всем монстрам, восстанавливает ${hp(4)}"
    ),
    cannon(
        "Пушка", "cannon.png",
        "Наносит ${dmg(2)}(1)и(2)",
        "Наносит ${dmg(5)}(1)и(2)"
    ),
    painshare(
        "Разделитель боли", "painshare.jpg",
        "Выберите игрока, вы делите весь полученный ${dmg} на двоих",
        "Выбранный игрок или монстр получает ${dmg("x2")} в этом цикле"
    ),
    ecstasy(
        "Таблетка экстази", "ecstasy.jpg",
        "Все игроки восстанавливают ${hp(1)}",
        "Эффекты монстров не работают в этом цикле, восстанавливаешь ${hp(2)}"
    ),
    tumbler(
        "Тумблер", "tumbler.jpg",
        "Перевернуть кубик вверх ногами",
        "Перевернуть кубик как хочешь"
    )
}