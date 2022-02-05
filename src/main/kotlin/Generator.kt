import java.io.File
import java.nio.charset.Charset


fun generateCreatures(){
    val isAnyEnabled = Creatures.values().any { it.isEnabled }
    val out = "Name,Description,Image,level,hp,Basedmg\n" + ",,,,,\n" +
    Creatures.values().filter { !isAnyEnabled || it.isEnabled }.joinToString("\n") {
        it.showName + "," +
                '"' + if(it.activeEffect != null){"(do): " + it.activeEffect.br + "<br>"} else {""} +
                if(it.passiveEffect != null){"(pass): " + it.passiveEffect.br + "<br>"} else {""} +
                it.level.hand + ": " + it.handEffect.br + '"' + "," +
                '"' + "images\\cover\\" + it.image + '"' + "," +
                it.level + "," +
                it.hp + "," +
                it.damage
    }

   File("nandeck\\creatures\\creatures.csv").writeText(out, Charset.forName("Windows-1251"))
}

fun generateItems(){
    val isAnyEnabled = Items.values().any { it.isEnabled }
    val out = "Name,Description,Image\n" + ",,\n" +
    Items.values().filter { !isAnyEnabled || it.isEnabled }.joinToString("\n") {
        it.showName + "," +
                '"' + "(do): " + it.activeEffect.br + "<br>" +
                if(it.passiveEffect != null){"(pass): " + it.passiveEffect.br + "<br>"} else {""} +
                "(trash): " + it.handEffect.br + '"' + "," +
                '"' + "images\\cover\\" + it.image + '"'
    }

   File("nandeck\\items\\items.csv").writeText(out, Charset.forName("Windows-1251"))
}

fun generateLocations(){
    val isAnyEnabled = Locations.values().any { it.isEnabled }
    val out = "Name,Description,Image,Arrangement\n" + ",,,\n" +
    Locations.values().filter { !isAnyEnabled || it.isEnabled }.joinToString("\n") {
        it.showName + "," +
                '"' + "(pass): " + it.passiveEffect.br + '"' + ',' +
                '"' + "images\\cover\\" + it.image + '"' + ',' +
        it.arrangement.joinToString("") { level -> level.toString() }
    }

   File("nandeck\\locations\\locations.csv").writeText(out, Charset.forName("Windows-1251"))
}

val String?.br get() = this?.replace("\n", "<br>")