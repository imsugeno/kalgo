# クラス - 解答と解説

## 解答コード

```kotlin
data class Employee(val name: String, val salary: Int)

fun main() {
    val n = readLine()!!.toInt()
    val employees = mutableListOf<Employee>()

    repeat(n) {
        val parts = readLine()!!.split(" ")
        employees.add(Employee(parts[0], parts[1].toInt()))
    }

    employees.forEach { println(it) }
    println("Average salary: ${employees.map { it.salary }.average().toInt()}")
    println("Highest paid: ${employees.maxByOrNull { it.salary }?.name}")
}
```

## 解説

### クラスの宣言
```kotlin
class Contact(val id: Int, var email: String)
```
- `val`: 読み取り専用プロパティ
- `var`: 変更可能なプロパティ
- コンストラクタの引数がそのままプロパティになる

### インスタンス化
```kotlin
val contact = Contact(1, "alice@example.com")
println(contact.email)  // alice@example.com
```

### メンバー関数
```kotlin
class Contact(val id: Int, var email: String) {
    fun printId() {
        println(id)
    }
}
```

### データクラス（data class）
`data class` を使うと以下が自動生成される：
| 機能 | 説明 |
|---|---|
| `toString()` | `Employee(name=Alice, salary=50000)` のような文字列表現 |
| `equals()` / `==` | プロパティの値に基づく等価比較 |
| `copy()` | インスタンスのコピーを作成 |
| `hashCode()` | ハッシュコード |

### copy() の使い方
```kotlin
val alice = Employee("Alice", 50000)
val aliceRaise = alice.copy(salary = 55000)
// Employee(name=Alice, salary=55000)
```

### ポイント
- データを保持するだけのクラスには `data class` を使う
- `maxByOrNull` は要素が0の場合 `null` を返すため `?.` で安全にアクセスする
