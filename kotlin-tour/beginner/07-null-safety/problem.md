# Null安全

## 学習テーマ
- Nullable型（`Type?`）
- 安全呼び出し演算子（`?.`）
- エルビス演算子（`?:`）
- nullチェック

## 問題

学生のスコアデータを処理するプログラムを作成してください。
入力データには `null` が含まれる可能性があります。

標準入力から学生データを読み取り、null安全な方法で処理してください。
文字列 `"null"` は null 値として扱ってください。

### 入力形式
```
N（学生数）
名前1 スコア1
名前2 スコア2
...
```
※ 名前やスコアが `"null"` の場合あり

### 出力形式
```
[名前（nullなら"Unknown"）]: [スコア（nullなら"N/A"）]
（N行繰り返し）
Valid scores: [null以外のスコア数]
Average score: [有効スコアの平均（整数）]
```

### 入出力例

**入力:**
```
5
Alice 85
Bob null
Charlie 92
null 78
Eve null
```

**出力:**
```
Alice: 85
Bob: N/A
Charlie: 92
Unknown: 78
Eve: N/A
Valid scores: 3
Average score: 85
```

## ヒント
- `?.` で null の場合にアクセスを安全にスキップできます
- `?:` で null の場合のデフォルト値を指定できます
- `filterNotNull()` でリストから null を除去できます
- `toIntOrNull()` は変換できない場合に null を返します
