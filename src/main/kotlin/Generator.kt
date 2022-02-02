import java.io.File
import java.nio.charset.Charset


fun generateCreatures(){
    val out = "Name,Description,Image,level,hp\n" + ",(do): <br>(buff): (trash): ,,W,\n" +
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

val String?.br get() = this?.replace("\n", "<br>")