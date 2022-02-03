import Level.*
import Tag.*


enum class Locations(
    val showName: String,
    val image: String,
    val passiveEffect: String,
    val arrangement: List<Level>
) {
    cursedchurch(
        "Пролклятая церковь", "cursedchurch.png",
        "Монстры наносят ${dmg("+1")}",
        listOf(W,W,W,M)
    ),
    spikeroom(
        "Комната с шипами", "spikeroom.png",
        "В конце каждого цикла игрок получает ${dmg(1)}",
        listOf(W,W,W,W)
    ),
    darkforest(
        "Тёмный лес", "darkforest.png",
        "В конце каждого цикла игрок теряет одну карту с руки",
        listOf(M,M,W,W)
    ),
    darkroom(
        "Тёмная комната", "darkroom.png",
        "Игрок не ходит в первом цикле",
        listOf(W,W,S)
    ),
    dinnerroom(
        "Обеденный зал", "dinnerroom.png",
        "У карт нет ограничений на номер позиции",
        listOf(S,S,M)
    ),
    stoneplato(
        "Каменное плато", "stoneplato.png",
        "На первом ходу у монстров ${arm(3)}",
    listOf(W,W,W,W,W)
    ),
    graveyard(
        "Кладбище", "graveyard.png",
        "Каждый цикл можно заменить монстра в руке",
        listOf(W,M,S)
    ),
    cliff(
        "Обрыв", "cliff.png",
        "После смерти монстров они просто сбрасываются",
        listOf(W,M,W,M)
    ),
    triumpharc(
        "Триумфальная арка", "triumpharc.png",
        "При победе забираем по монстру из руки каждого игрока",
        listOf(S,S,S)
    ),
    throneroom(
        "Тронный зал", "throneroom.png",
        "Блок у игрока и монстров не спадает в конце циклов",
        listOf(S,W,W,W,W,W)
    ),
    tightroom(
        "Тесная комната", "tightroom.png",
        "Можно использовать только 3 предмета за цикл",
        listOf(S)
    ),
    basement(
        "Подвал", "basement.png",
        "Нельзя использовать эффекты выбрасывания",
        listOf(M,S)
    )
}