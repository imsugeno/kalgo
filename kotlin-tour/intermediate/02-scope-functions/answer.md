# スコープ関数 - 解答と解説

## 解答コード

```kotlin
data class User(var name: String, var email: String, var age: Int)

fun main() {
    val inputName = readLine()!!
    val inputEmail = readLine()!!
    val inputAge = readLine()!!.toInt()

    // also: 副作用（ログ出力）
    val user = User(inputName, inputEmail, inputAge).also {
        println("Creating user: ${it.name}")
    }

    // with: オブジェクトの複数プロパティにアクセス
    with(user) {
        println("User(name=$name, email=$email, age=$age)")
    }

    // let: 変換処理
    val nameLength = user.name.let { it.length }
    println("Name length: $nameLength")

    // apply: オブジェクトの変更
    user.apply {
        email = "${name.lowercase()}_updated@example.com"
    }
    println("Updated email: ${user.email}")
}
```

## 解説

### let
- アクセス: `it`、戻り値: ラムダの結果
- null安全操作や変換に最適
```kotlin
val length = name?.let { it.length } ?: 0
```

### apply
- アクセス: `this`（暗黙的）、戻り値: オブジェクト自体
- オブジェクトの初期化・設定に最適
```kotlin
val user = User().apply {
    name = "Alice"
    email = "alice@example.com"
}
```

### run
- アクセス: `this`、戻り値: ラムダの結果
- 初期化して結果を取得する場合に最適
```kotlin
val result = user.run {
    "$name ($email)"
}
```

### also
- アクセス: `it`、戻り値: オブジェクト自体
- 副作用（ログ出力、デバッグ）に最適
```kotlin
numbers.also { println("Before: $it") }
    .sorted()
    .also { println("After: $it") }
```

### with
- アクセス: `this`、戻り値: ラムダの結果
- 拡張関数ではない（引数としてオブジェクトを渡す）
```kotlin
with(canvas) {
    drawLine(0, 0, 100, 100)
    drawCircle(50, 50, 25)
}
```

### 使い分けのポイント
- オブジェクト初期化 → `apply`
- null安全操作 → `let`
- ログ・デバッグ → `also`
- 計算結果が必要 → `run` または `let`
- 複数操作をまとめる → `with`
