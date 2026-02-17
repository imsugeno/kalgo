# コレクション

## 学習テーマ
- `List`（リスト）: 順序付きのコレクション（重複許可）
- `Set`（セット）: 一意な要素のコレクション
- `Map`（マップ）: キーと値のペア
- コレクション操作: `count()`, `first()`, `last()`, `in` 演算子

## 問題

標準入力から果物名のリストを読み取り、以下のコレクション操作を行った結果を出力してください。

### 入力形式
```
N（要素数）
果物1 果物2 果物3 ...（スペース区切り）
検索する果物名
```

### 出力形式
```
List: [リスト内容]
Count: [要素数]
First: [最初の要素]
Last: [最後の要素]
Unique: [重複除去したセット]
Unique count: [ユニーク数]
[検索果物] found: [true/false]
```

### 入出力例

**入力:**
```
6
apple banana cherry apple banana dragonfruit
grape
```

**出力:**
```
List: [apple, banana, cherry, apple, banana, dragonfruit]
Count: 6
First: apple
Last: dragonfruit
Unique: [apple, banana, cherry, dragonfruit]
Unique count: 4
grape found: false
```

## ヒント
- `split(" ")` でスペース区切りの文字列をリストに変換できます
- `toSet()` でリストからセットに変換できます
- `in` 演算子で要素の存在確認ができます
