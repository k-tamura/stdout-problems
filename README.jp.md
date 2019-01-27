標準出力に関する問題を再現するアプリケーション
=

Qiitaで解説した標準出力に関する問題を再現するためのアプリケーションです。バッチ（.bat）実行の問題なので、Windows上でのみ実行可能です。

## ビルド

まずは、`git clone`してできた`stdout-problems`に移動して、アプリケーションをビルドして下さい。

    $ git clone https://github.com/k-tamura/stdout-problems.git
    $ cd stdout-problems
    $ mvn clean package

## バッチファイルの実行方法

バッチファイルの実行方法は以下の3種類があります。

 - バッチファイルを単独で実行
 - バッチファイルをJava経由で実行
 - バッチファイルをWebアプリケーション（RMI）経由で実行
 
 いずれも実行すると、`logs/result.log`にバッチの実行結果が出力されます。

### バッチファイルを単独で実行

    $ target\classes\annual.bat
    
### バッチファイルをJava経由で実行

    $ java -cp target\ROOT\WEB-INF\classes;target\ROOT\WEB-INF\lib\spring-core-4.3.10.RELEASE.jar;target\ROOT\WEB-INF\lib\commons-io-2.5.jar org.t246osslab.stdoutproblems.batch.BatchImpl

### バッチファイルをWebアプリケーション（RMI）経由で実行

    $ mvn spring-boot:run


以下にアクセスし、バッチ実行ボタンをクリック:

    http://localhost:8080


停止するには:

  <kbd>CTRL</kbd>+<kbd>C</kbd>をクリック
  
## 動作確認

### ① 事象の再現

まずは、上記手順で事象を再現させてみます。

 - バッチファイルを単独で実行 → 正常に完了
 - バッチファイルをJava経由で実行 → 途中で停止
 - バッチファイルをWebアプリケーション（RMI）経由で実行 → 画面でボタンをクリックした後に応答は即ぐに返るが、バッチが途中で停止する

### ② 誤った対策

次に、`System.out.println();`を追加して動作確認してみましょう。
`src/main/java/org/t246osslab/stdoutproblems/batch/BatchImpl.java`にある次の2行のコメントを解除します。

```java
// import org.apache.commons.io.IOUtils;
// System.out.println(IOUtils.toString(process.getInputStream(), "UTF-8"));
```

ビルドして、以下を確認してみて下さい。

 - バッチファイルを単独で実行 → 正常に完了
 - バッチファイルをJava経由で実行 → 正常に完了（途中で停止しない）
 - バッチファイルをWebアプリケーション（RMI）経由で実行 → 画面でボタンをクリックした後に応答が即ぐに返らなくなる
 
### ③ 正しい対策

最後に、`System.out.println();`を削除して、`@echo off`を追加し動作確認してみましょう。
先ほど修正した次の2行を再度コメントアウトします。

```java
import org.apache.commons.io.IOUtils;
System.out.println(IOUtils.toString(process.getInputStream(), "UTF-8"));
```

`src/main/resources/annual.bat`の先頭に`@echo off`の１行を追加します。
 
 ビルドして、以下を確認してみて下さい。
 
 - バッチファイルを単独で実行 → 正常に完了
 - バッチファイルをJava経由で実行 → 正常に完了（途中で停止しない）
 - バッチファイルをWebアプリケーション（RMI）経由で実行 → 正常に完了（画面でボタンをクリックした後に応答が即ぐに返る）
