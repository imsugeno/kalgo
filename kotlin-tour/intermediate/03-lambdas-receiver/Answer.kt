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
