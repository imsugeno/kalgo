data class User(var name: String, var email: String, var age: Int)

fun main() {
    val inputName = readLine()!!
    val inputEmail = readLine()!!
    val inputAge = readLine()!!.toInt()

    // also を使って "Creating user: [名前]" を出力しつつ User を作成
    // TODO: ここにコードを書いてください

    // with を使って "User(name=..., email=..., age=...)" を出力
    // TODO: ここにコードを書いてください

    // let を使って名前の文字数を取得し "Name length: [数]" を出力
    // TODO: ここにコードを書いてください

    // apply を使ってメールアドレスを "[名前の小文字]_updated@example.com" に更新
    // "Updated email: [新メール]" を出力
    // TODO: ここにコードを書いてください
}
