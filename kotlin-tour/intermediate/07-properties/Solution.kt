class Thermostat {
    val history = mutableListOf<Double>()

    // カスタムsetterを持つtemperatureプロパティ
    // - 0°C未満なら警告を出力
    // - バッキングフィールドに値を設定
    // - 履歴に追加
    // - 設定メッセージを出力
    // TODO: ここにコードを書いてください

    // カスタムgetterで華氏を返すプロパティ
    // TODO: ここにコードを書いてください
}

fun main() {
    val thermostat = Thermostat()
    val n = readLine()!!.toInt()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        thermostat.temperature = parts[2].toDouble()
    }

    println("Latest: ${"%.1f".format(thermostat.temperature)}°C")
    println("History: ${thermostat.history}")
}
