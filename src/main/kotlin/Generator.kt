import java.io.File
import java.nio.charset.Charset
import Tag.*


fun generateLivingThings() {
    val isAnyEnabled = LivingThings.values().any { it.isEnabled }
    val out = "Name,Description,Image,level,hp,type,Basedmg\n" + ",,,,,," + '\n' +
            LivingThings.values().filter { !isAnyEnabled || it.isEnabled }.joinToString("\n") {
                it.showName + "," +
                '"' +
                (if (it.activeEffect != null) "$doe: ${it.activeEffect.br}<br>" else "") +
                (if (it.passiveEffect != null) "$pass: ${it.passiveEffect.br}<br>" else "") +
                '"' + "," +
                '"' + "images\\cover\\" + it.image + '"' + "," +
                it.level + "," +
                it.hp + "," +
                it.type.icon + "," +
                it.damage
            }

   File("nandeck\\living_things\\living_things.csv").writeText(out, Charset.forName("Windows-1251"))
}

fun generateSurvivors(){
    val isAnyEnabled = Survivors.values().any { it.isEnabled }
    val out = "Name,Description,Image,Hp\n" + ",,," + '\n' +
            Survivors.values().filter { !isAnyEnabled || it.isEnabled }.joinToString("\n") {
        it.showName + "," +
                '"' +
                (if (it.activeEffect != null) "$doe: ${it.activeEffect.br}<br>" else "") +
                (if (it.passiveEffect != null) "$pass: ${it.passiveEffect.br}<br>" else "") +
                "${it.harmType}${it.harmEffect.second}: " + it.harmEffect.first +
                '"' + "," +
                '"' + "images\\cover\\" + it.image + '"' + ',' +
                it.hp
    }

   File("nandeck\\survivors\\survivors.csv").writeText(out, Charset.forName("Windows-1251"))
}

fun generateLocations(){
    val isAnyEnabled = Locations.values().any { it.isEnabled }
    val out = "Name,Description,Image,Arrangement\n" + ",,,\n" +
    Locations.values().filter { !isAnyEnabled || it.isEnabled }.joinToString("\n") {
        it.showName + "," +
                '"' + "$pass: " + it.passiveEffect.br + '"' + ',' +
                '"' + "images\\cover\\" + it.image + '"' + ',' +
        it.arrangement.joinToString("") { level -> level.toString() }
    }

   File("nandeck\\locations\\locations.csv").writeText(out, Charset.forName("Windows-1251"))
}

val String?.br get() = this?.replace("\n", "<br>")