# 基本型と算術演算 - 解答と解説

## 解答コード

```kotlin
fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    println("a + b = ${a + b}")
    println("a - b = ${a - b}")
    println("a * b = ${a * b}")
    println("a / b = ${a / b}")
    println("a % b = ${a % b}")
    println("a.toDouble() / b = ${a.toDouble() / b}")
}
```

## 解説

### 基本型
Kotlinの主な基本型：
| 型 | 説明 | 例 |
|---|---|---|
| `Int` | 整数 | `42` |
| `Double` | 倍精度浮動小数点数 | `3.14` |
| `Boolean` | 真偽値 | `true`, `false` |
| `String` | 文字列 | `"Hello"` |
| `Char` | 単一文字 | `'A'` |

### 算術演算子
| 演算子 | 意味 | 例 |
|---|---|---|
| `+` | 加算 | `17 + 5 = 22` |
| `-` | 減算 | `17 - 5 = 12` |
| `*` | 乗算 | `17 * 5 = 85` |
| `/` | 除算 | `17 / 5 = 3`（整数除算） |
| `%` | 剰余 | `17 % 5 = 2` |

### 型変換
- `Int` 同士の `/` は整数除算（小数点以下切り捨て）
- `toDouble()` で `Int` を `Double` に変換すると浮動小数点除算になる
- `17.toDouble() / 5` → `3.4`

### 拡張代入演算子
`+=`, `-=`, `*=`, `/=`, `%=` も使える：
```kotlin
var x = 10
x += 5  // x = 15
x *= 2  // x = 30
```
