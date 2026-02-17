# オブジェクト

## 学習テーマ
- `object` 宣言（シングルトン）
- `companion object`（ファクトリメソッド）
- `data object`

## 問題

温度変換プログラムを作成してください。

1. `Temperature` データクラスに `companion object` でファクトリメソッドを実装
2. `ConversionCounter` オブジェクト宣言で変換回数を追跡

### 入力形式
```
N（クエリ数）
単位 温度値
```
- `celsius [値]` → 摂氏から華氏に変換
- `fahrenheit [値]` → 華氏から摂氏に変換

### 出力形式
```
[入力値]°C = [変換値]°F（または逆）
（N行繰り返し）
Conversions performed: [変換回数]
```
※ 数値は小数点以下1桁

### 入出力例

**入力:**
```
3
celsius 100.0
fahrenheit 32.0
celsius 37.0
```

**出力:**
```
100.0°C = 212.0°F
32.0°F = 0.0°C
37.0°C = 98.6°F
Conversions performed: 3
```

## ヒント
- 摂氏→華氏: `C * 9 / 5 + 32`
- 華氏→摂氏: `(F - 32) * 5 / 9`
- `companion object` でファクトリメソッド `fromFahrenheit()` を実装
- `object` 宣言でカウンターを管理
