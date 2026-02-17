# 拡張関数 - 解答と解説

## 解答コード

```kotlin
fun String.wordCount(): Int = this.split(" ").count()

fun String.isPalindrome(): Boolean {
    val cleaned = this.lowercase().replace(" ", "")
    return cleaned == cleaned.reversed()
}

fun Int.factorial(): Long {
    var result = 1L
    for (i in 1..this) {
        result *= i
    }
    return result
}

fun main() {
    val n = readLine()!!.toInt()
    repeat(n) {
        val line = readLine()!!
        val spaceIndex = line.indexOf(' ')
        val command = line.substring(0, spaceIndex)
        val arg = line.substring(spaceIndex + 1)

        when (command) {
            "words" -> println(arg.wordCount())
            "palindrome" -> println(arg.isPalindrome())
            "factorial" -> println(arg.toInt().factorial())
        }
    }
}
```

## 解説

### 拡張関数の構文
```kotlin
fun クラス名.関数名(引数): 戻り値型 {
    // this でレシーバにアクセス
}
```

### レシーバ（this）
拡張関数内の `this` は、その関数が呼び出されたオブジェクトを指す：
```kotlin
fun String.bold(): String = "<b>$this</b>"
"hello".bold()  // <b>hello</b>
```

### 拡張関数の利点
- 既存クラスのソースコードを変更せずに機能を追加できる
- サードパーティライブラリのクラスにも適用可能
- コードの可読性が向上
- Kotlin標準ライブラリでも広く使われている

### 拡張指向デザイン
コア機能と付加的な機能を分離することで、クラスをシンプルに保てる：
```kotlin
class HttpClient {
    fun request(method: String, url: String): Response { ... }
}

// 便利な拡張関数
fun HttpClient.get(url: String) = request("GET", url)
fun HttpClient.post(url: String) = request("POST", url)
```
