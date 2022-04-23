val recently = 0..60
val minute_ago = 61..3600
val hours_ago = 3601..86400
val today = 86401..172800
val yesterday = 172801..2 * 172800
fun main() {
    println(agoToText(58))
    println(agoToText(1320))
    println(agoToText(79200))
    println(agoToText(90000))
    println(agoToText(172802))
    println(agoToText(400000))


}

fun agoToText(time: Int): String {
    return when {
        recently.contains(time) -> "Был(а) только что"
        minute_ago.contains(time) -> format_minute(time / 60)
        hours_ago.contains(time) -> format_hours(time / 3600)
        today.contains(time) -> "Был(а) сегодня"
        yesterday.contains(time) -> "Был(а) вчера"

        else -> "Был(а) давно"
    }
}

fun format_minute(time: Int): String {

    return when {
        (time.toString().last()).equals('2') || (time.toString().last()).equals('3') || (time.toString().last()).equals(
            '4'
        ) -> "Был(а) $time минуты назад"

        (time.toString().last()).equals('1') && time != 11 -> "Был(а) $time минуту назад"

        else -> " Был(а) $time минут назад "
    }

}

fun format_hours(time: Int): String {
    val a = 5..20
    return when {
        (time.toString().last()).equals('1') -> "Был(а) $time час назад"

        a.contains(time) -> "Был(а) $time часов назад"

        else -> "Был(а) ${time} часа назад"
    }
}




