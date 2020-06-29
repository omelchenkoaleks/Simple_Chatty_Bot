import java.util.*
import kotlin.system.exitProcess

val scanner = Scanner(System.`in`)
val words = mutableMapOf<Int, String>()
val coincidence = mutableMapOf<String, Int>()
const val STOP = "stop"

fun main() {
    var key = 1
    var word = scanner.nextLine()

    while (word != STOP) {

        words[key] = word
        for (entry in words) {
            if (entry.value == word) {
                if (coincidence.containsKey(word)) {
                    if (coincidence.containsValue(1)) {
                        coincidence[word] = 2
                        if (coincidence.containsValue(1)) {
                            coincidence[word] = 3
                            if (coincidence.containsValue(1)) {
                                coincidence[word] = 4
                                if (coincidence.containsValue(1)) {
                                    coincidence[word] = 5
                                } else {
                                    coincidence[word] = 4
                                }
                            } else {
                                coincidence[word] = 3
                            }
                        } else {
                            coincidence[word] = 2
                        }
                    } else {
                        coincidence[word] = 1
                    }
                } else {
                    coincidence[word] = 0
                }
            }
        }
        key++
        word = scanner.nextLine()

    }

    val max = coincidence.values
    var res = ""
    for (maxValue in coincidence) {
        if (maxValue.value == max.max() ) {
            res = maxValue.key
            break
        }
    }

    if (word == STOP) {
        if (words.isEmpty()) {
            print("null")
        }
        print(res)
        exitProcess(0)
    }
}