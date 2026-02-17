# Null安全（中級）- 解答と解説

## 解答コード

```kotlin
data class StudentRecord(val name: String?, val score: Int?, val subject: String?)

fun parseRecord(line: String): StudentRecord {
    val parts = line.split(" ")
    return StudentRecord(
        name = parts[0].takeIf { it != "null" },
        score = parts[1].takeIf { it != "null" }?.toInt(),
        subject = parts[2].takeIf { it != "null" }
    )
}

fun formatRecord(record: StudentRecord): String? {
    val (name, score, subject) = record

    // 全てnullなら無効レコード
    if (name == null && score == null && subject == null) return null

    val displayName = name ?: "Unknown"
    val displaySubject = subject ?: "Unknown Subject"

    return if (score != null) {
        "$displayName scored $score in $displaySubject"
    } else {
        "$displayName: score not available for $displaySubject"
    }
}

fun main() {
    val n = readLine()!!.toInt()
    val records = List(n) { parseRecord(readLine()!!) }

    val validScores = mutableListOf<Int>()

    records.forEach { record ->
        val formatted = formatRecord(record)
        if (formatted != null) {
            println(formatted)
            record.score?.let { validScores.add(it) }
        } else {
            println("Invalid record skipped")
        }
    }

    println("Valid records: ${validScores.size}")
    if (validScores.isNotEmpty()) {
        println("Average score: ${validScores.average().toInt()}")
    }
}
```

## 解説

### スマートキャスト
`is` でチェックした後、自動的にキャストされる：
```kotlin
fun process(obj: Any) {
    if (obj is String) {
        println(obj.length)  // String として扱える
    }
}
```

### 安全キャスト（as?）
失敗時に null を返す：
```kotlin
val str = obj as? String  // 失敗なら null
val length = (obj as? String)?.length ?: 0
```

### takeIf()
条件が真の場合のみ値を返す（偽なら null）：
```kotlin
val value = "null".takeIf { it != "null" }  // null
val value = "hello".takeIf { it != "null" } // "hello"
```

### null安全なコレクション関数
| 関数 | 用途 |
|---|---|
| `filterNotNull()` | nullを除去 |
| `mapNotNull { }` | 変換してnullを除去 |
| `listOfNotNull()` | null除外でリスト作成 |
| `firstNotNullOfOrNull { }` | 最初のnon-null値 |
| `maxOrNull()` / `minOrNull()` | null安全な最大/最小 |

### Elvisオペレータ + 早期リターン
```kotlin
fun process(user: User?): String {
    val name = user?.name ?: return "No user"
    return "Hello, $name"
}
```

### 分割宣言（destructuring）
data class のプロパティを個別の変数に展開：
```kotlin
val (name, score, subject) = record
```
