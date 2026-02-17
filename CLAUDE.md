# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## プロジェクト概要

Go開発者向けのKotlin学習教材リポジトリ。`kotlin-tour/` に体系的な演習問題を収録し、Claudeスキルで学習サポート（`/kotlin-learn`）とコードレビュー（`/kotlin-review`）を提供する。

## ビルド・実行

Gradle/Mavenは使わず、`kotlinc` で直接コンパイルする。

```bash
cd kotlin-tour/beginner/01-hello-world/
kotlinc Solution.kt -include-runtime -d Solution.jar
java -jar Solution.jar < input.txt
```

VS Code では `Cmd+Shift+B` でアクティブファイルをコンパイル・実行できる（`.vscode/tasks.json` 設定済み）。

## 演習ディレクトリ構成

各演習は以下の5ファイルで構成される（`kotlin-tour/{beginner,intermediate}/XX-topic-name/`）:

| ファイル | 役割 |
|---------|------|
| `problem.md` | 問題文・入出力仕様 |
| `Solution.kt` | 学習者が書くコード |
| `Answer.kt` | 模範解答 |
| `answer.md` | 解説（イディオム・ベストプラクティス） |
| `input.txt` | テスト用標準入力 |

## Claudeスキル

- `/kotlin-learn <質問>` — ソクラテス式チューター。コード生成禁止、ヒントと概念説明のみ
- `/kotlin-review <Solution.ktパス>` — Solution.kt を模範解答と比較し100点満点で採点、`review.md` に出力

両スキルとも `mcp__deepwiki__ask_question`（`JetBrains/kotlin`）で最新仕様を確認してからレビュー・回答する。

## 重要な方針

- **対象ユーザーはGo開発者** — 説明・レビューでは常にGoとの対比を意識する
- **日本語で応答する**
- **学習者の理解促進が目的** — 答えの丸写しではなくヒントや方向性を示す
