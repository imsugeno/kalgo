# ライブラリとAPI

## 学習テーマ
- Kotlin標準ライブラリの活用
- コレクション操作（`map`, `filter`, `sorted`, `groupBy`, `sumOf`）
- 文字列操作（`reversed`, `uppercase`, `lowercase`）
- 数学関数（`kotlin.math`）

## 問題

学生のテストスコアを分析するプログラムを作成してください。
標準ライブラリの関数を活用して、各種統計を計算します。

### 入力形式
```
N（学生数）
スコア1 スコア2 ... スコアN（スペース区切り）
```

### グレード基準
- 90以上: `A`
- 80以上: `B`
- 70以上: `C`
- 60以上: `D`
- 60未満: `F`

### 出力形式
```
Scores: [スコアリスト]
Sorted: [ソート済みリスト]
Average: [平均（小数点1桁）]
Max: [最高点]
Min: [最低点]
Above average: [平均以上のスコアリスト]
Grade distribution: {グレード=人数, ...}
```

### 入出力例

**入力:**
```
5
72 85 90 68 95
```

**出力:**
```
Scores: [72, 85, 90, 68, 95]
Sorted: [68, 72, 85, 90, 95]
Average: 82.0
Max: 95
Min: 68
Above average: [85, 90, 95]
Grade distribution: {C=1, B=1, A=2, D=1}
```

## ヒント
- `sorted()` でソート
- `average()` で平均値
- `maxOrNull()`, `minOrNull()` で最大・最小
- `filter { }` で条件に合う要素を抽出
- `groupBy { }` でグループ分け
- `mapValues { it.value.size }` でグループの要素数を取得
