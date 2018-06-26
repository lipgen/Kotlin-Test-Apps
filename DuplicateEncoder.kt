import java.util.*

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)
    while (reader.hasNextLine()){
        var str = reader.nextLine()
        var arrayInt = mutableMapOf<Char, Int>()
        str = str.toLowerCase()
        var i = 0
        while (i < str.length) {
            if (!arrayInt.containsKey(str[i])) {
                var res = 1
                var j: Int = i + 1
                while (j < str.length) {
                    if (str[i] == str[j]) res++
                    j++
                }
                arrayInt.put(str[i],res)
            }
            i++
        }
        for (item in arrayInt) {
            if(item.value>1)
                str = str.replace(item.key,')')
            else
                str = str.replace(item.key,'(')
        }
        println(str)
    }
}
