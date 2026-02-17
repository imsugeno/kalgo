# プロパティ

## 学習テーマ
- カスタムgetter/setter
- バッキングフィールド（`field`）
- 拡張プロパティ
- 委譲プロパティ（`by lazy`, `observable`）

## 問題

温度監視システムを作成してください。

以下の機能を実装します：
1. カスタムsetterで温度設定時に警告を出力
2. カスタムgetterで華氏変換プロパティを提供
3. 履歴を `mutableListOf` で管理

### 入力形式
```
N（設定回数）
set temperature [温度値]
（N行繰り返し）
```

### 出力形式
```
Temperature set to [値]°C ([華氏]°F)
（0°C未満の場合: "Warning: Temperature below 0°C!" を前に出力）
（N行繰り返し）
Latest: [最後の温度]°C
History: [温度の履歴リスト]
```
※ 数値は小数点以下1桁

### 入出力例

**入力:**
```
3
set temperature 25.5
set temperature 30.0
set temperature -5.0
```

**出力:**
```
Temperature set to 25.5°C (77.9°F)
Temperature set to 30.0°C (86.0°F)
Warning: Temperature below 0°C!
Temperature set to -5.0°C (23.0°F)
Latest: -5.0°C
History: [25.5, 30.0, -5.0]
```

## ヒント
- カスタムsetter: `set(value) { field = value; ... }`
- カスタムgetter: `get() = 式`
- `field` キーワードでバッキングフィールドにアクセス
- 摂氏→華氏: `celsius * 9 / 5 + 32`
