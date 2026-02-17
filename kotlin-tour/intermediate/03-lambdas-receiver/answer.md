# レシーバ付きラムダ式 - 解答と解説

## 解答コード

```kotlin
class HtmlBuilder {
    private val content = StringBuilder()

    fun head(title: String) {
        content.appendLine("  <head>$title</head>")
    }

    fun body(block: BodyBuilder.() -> Unit) {
        content.appendLine("  <body>")
        val bodyBuilder = BodyBuilder()
        bodyBuilder.block()
        content.append(bodyBuilder.build())
        content.appendLine("  </body>")
    }

    fun build(): String = "<html>\n${content}</html>"
}

class BodyBuilder {
    private val content = StringBuilder()

    fun p(text: String) {
        content.appendLine("    <p>$text</p>")
    }

    fun build(): String = content.toString()
}

fun html(block: HtmlBuilder.() -> Unit): String {
    val builder = HtmlBuilder()
    builder.block()
    return builder.build()
}

fun main() {
    val title = readLine()!!
    val n = readLine()!!.toInt()
    val paragraphs = List(n) { readLine()!! }

    val result = html {
        head(title)
        body {
            paragraphs.forEach { p(it) }
        }
    }

    print(result)
}
```

## 解説

### レシーバ付きラムダの型
```kotlin
ReceiverType.() -> ReturnType
```
- ラムダ内で `this` がレシーバのインスタンスを指す
- メンバー関数やプロパティに直接アクセスできる

### DSLパターン
レシーバ付きラムダを使うと、宣言的なDSLを構築できる：
```kotlin
html {
    head("Title")
    body {
        p("Hello")
    }
}
```

### buildString / buildList
Kotlin標準ライブラリのビルダー関数もこのパターンを使用：
```kotlin
val str = buildString {
    append("Hello")
    append(", ")
    append("World!")
}
// "Hello, World!"

val list = buildList {
    add(1)
    add(2)
    add(3)
}
// [1, 2, 3]
```

### ポイント
- レシーバ付きラムダにより、ネストされた構造を自然に表現できる
- コンパイル時の型安全性が保証される
- Kotlin の Gradle DSL、Ktor、Compose なども同じパターンを使用
