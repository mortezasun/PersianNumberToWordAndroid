import java.math.BigDecimal

class PersianNumberToWord (private val num: BigDecimal?,private val unit: String){
    fun create(): String {
        return onDo(num, 0) + " " + unit
    }
    private val yekan = arrayOf(
        " یک ",
        " دو ",
        " سه ",
        " چهار ",
        " پنج ",
        " شش ",
        " هفت ",
        " هشت ",
        " نه "
    )
    private val dahgan = arrayOf(
        " بیست ",
        " سی ",
        " چهل ",
        " پنجاه ",
        " شصت ",
        " هفتاد ",
        " هشتاد ",
        " نود "
    )
    private val sadgan = arrayOf(
        " یکصد ",
        " دویست ",
        " سیصد ",
        " چهارصد ",
        " پانصد ",
        " ششصد ",
        " هفتصد ",
        " هشتصد ",
        " نهصد "
    )
    private val dah = arrayOf(
        " ده ",
        " یازده ",
        " دوازده ",
        " سیزده ",
        " چهارده ",
        " پانزده ",
        " شانزده ",
        " هفده ",
        " هیجده ",
        " نوزده "
    )



    private fun onDo(number: BigDecimal?, levels: Int): String {
        var num = number
        var level = levels
        if (num == null) {
            return ""
        }
        // convert negative number to positive and get wordify value
        if (num < BigDecimal(0)) {
            num = num.negate()
            return "منفی " + onDo(num, level)
        }
        if (num.compareTo(BigDecimal(0)) == 0) {
            return if (level == 0) {
                "صفر"
            } else {
                ""
            }
        }
        var result = ""
        if (level > 0) {
            result += " و "
            level -= 1
        }
        when {
            num < BigDecimal(10) -> {
                result += yekan[num.add(BigDecimal(1).negate()).toInt()]
            }
            num < BigDecimal(20) -> {
                result += dah[num.add(BigDecimal(10).negate()).toInt()]
            }
            num < BigDecimal(100) -> {
                result += dahgan[num.divide(BigDecimal(10)).add(BigDecimal(2).negate())
                    .toInt()] + onDo(
                    num.remainder(BigDecimal(10)),
                    level + 1
                )
            }
            num < BigDecimal(1000) -> {
                result += sadgan[num.divide(BigDecimal(100)).add(BigDecimal(1).negate())
                    .toInt()] + onDo(
                    num.remainder(BigDecimal(100)),
                    level + 1
                )
            }
            num < BigDecimal(1000000) -> {
                result += onDo(
                    num.divide(BigDecimal(1000)),
                    level
                ) + " هزار " + onDo(
                    num.remainder(BigDecimal(1000)),
                    level + 1
                )
            }
            num < BigDecimal(1000000000) -> {
                result += onDo(
                    num.divide(BigDecimal(1000000)),
                    level
                ) + " میلیون " + onDo(
                    num.remainder(BigDecimal(1000000)),
                    level + 1
                )
            }
            num < BigDecimal(java.lang.Long.valueOf("1000000000000")) -> {
                result += onDo(
                    num.divide(BigDecimal("1000000000".toLong())),
                    level
                ) + " میلیارد " + onDo(
                    num.remainder(BigDecimal("1000000000".toLong())),
                    level + 1
                )
            }
            num < BigDecimal(java.lang.Long.valueOf("1000000000000000")) -> {
                result += onDo(
                    num.divide(BigDecimal("1000000000000".toLong())),
                    level
                ) + " تریلیارد " + onDo(
                    num.remainder(BigDecimal("1000000000000".toLong())),
                    level + 1
                )
            }
        }
        return result
    }
}
