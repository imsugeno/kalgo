# Null安全（中級）

## 学習テーマ
- スマートキャスト（`is` 演算子）
- 安全キャスト（`as?`）
- null安全なコレクション関数（`filterNotNull`, `mapNotNull`, `firstNotNullOfOrNull`）
- Elvisオペレータと早期リターン
- `takeIf()`

## 問題

学生の成績データを処理するプログラムを作成してください。
入力データにはnull値（文字列 `"null"`）が含まれる可能性があります。

高度なnull安全パターンを使って、堅牢にデータを処理してください。

### 入力形式
```
N（レコード数）
名前 スコア 科目
```
※ 各フィールドが `"null"` の場合あり

### 出力形式
- 名前がnull → `"Unknown"`
- スコアがnull → `"score not available"`
- 科目がnull → `"Unknown Subject"`
- 全フィールドがnull → `"Invalid record skipped"`

### 入出力例

**入力:**
```
5
Alice 85 Math
null 90 Science
Bob null History
Charlie 75 null
null null null
```

**出力:**
```
Alice scored 85 in Math
Unknown scored 90 in Science
Bob: score not available for History
Charlie scored 75 in Unknown Subject
Invalid record skipped
Valid records: 3
Average score: 83
```

## ヒント
- 全フィールドnullチェック → 早期リターン的に先に処理
- `toIntOrNull()` でnull安全な変換
- `filterNotNull()` でnull除去
- スコアがある場合: `"[名前] scored [スコア] in [科目]"`
- スコアがない場合: `"[名前]: score not available for [科目]"`
