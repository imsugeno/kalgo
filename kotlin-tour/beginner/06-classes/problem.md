# クラス

## 学習テーマ
- クラスの宣言とインスタンス化
- プロパティ（`val`/`var`）
- メンバー関数
- データクラス（`data class`）
- `toString()`, `==`, `copy()`

## 問題

従業員（Employee）のデータを管理するプログラムを作成してください。

`data class Employee(val name: String, val salary: Int)` を定義し、
標準入力から従業員データを読み取って以下の操作を行ってください。

### 入力形式
```
N（従業員数）
名前1 給与1
名前2 給与2
...
```

### 出力形式
```
[Employee のtoString() をN行]
Average salary: [平均給与（整数）]
Highest paid: [最高給与の従業員名]
```

### 入出力例

**入力:**
```
3
Alice 50000
Bob 60000
Charlie 45000
```

**出力:**
```
Employee(name=Alice, salary=50000)
Employee(name=Bob, salary=60000)
Employee(name=Charlie, salary=45000)
Average salary: 51666
Highest paid: Bob
```

## ヒント
- `data class` は自動的に `toString()` を生成します
- `maxByOrNull { }` で条件に基づく最大要素を取得できます
- 平均値の計算: `list.map { it.salary }.average().toInt()`
