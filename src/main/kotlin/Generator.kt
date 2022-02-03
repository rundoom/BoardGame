import java.io.File
import java.nio.charset.Charset


fun generateCreatures(){
    val out = "Name,Description,Image,level,hp\n" + ",,,,\n" +
    Creatures.values().joinToString("\n") {
        it.showName + "," +
                '"' + "(do): " + it.activeEffect.br + "<br>" +
                if(it.passiveEffect != null){"(pass): " + it.passiveEffect.br + "<br>"} else {""} +
                it.level.hand + ": " + it.handEffect.br + '"' + "," +
                '"' + "images\\cover\\" + it.image + '"' + "," +
                it.level + "," +
                it.hp
    }

   File("nandeck\\creatures\\creatures.csv").writeText(out, Charset.forName("Windows-1251"))
}

fun generateItems(){
    val out = "Name,Description,Image\n" + ",,\n" +
    Items.values().joinToString("\n") {
        it.showName + "," +
                '"' + "(do): " + it.activeEffect.br + "<br>" +
                if(it.passiveEffect != null){"(pass): " + it.passiveEffect.br + "<br>"} else {""} +
                "(trash): " + it.handEffect.br + '"' + "," +
                '"' + "images\\cover\\" + it.image + '"'
    }

   File("nandeck\\items\\items.csv").writeText(out, Charset.forName("Windows-1251"))
}

fun generateLocations(){
    val out = "Name,Description,Image,Arrangement\n" + ",,,\n" +
    Locations.values().joinToString("\n") {
        it.showName + "," +
                '"' + "(pass): " + it.passiveEffect.br + '"' + ',' +
                '"' + "images\\cover\\" + it.image + '"' + ',' +
        it.arrangement.joinToString("") { level -> level.toString() }
    }

   File("nandeck\\locations\\locations.csv").writeText(out, Charset.forName("Windows-1251"))
}

val String?.br get() = this?.replace("\n", "<br>")