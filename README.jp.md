標準出力に関する問題を再現するアプリケーション
=

標準出力に関する問題を再現するためのアプリケーションです。バッチ（.bat）実行の問題なので、Windows上でのみ実行可能です。

ビルド
-

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

バッチファイルを単独で実行
-

    $ target\classes\annual.bat
    
バッチファイルをJava経由で実行
-

    $ java -cp target\ROOT\WEB-INF\classes;target\ROOT\WEB-INF\lib\spring-core-4.3.10.RELEASE.jar;target\ROOT\WEB-INF\lib\commons-io-2.5.jar org.t246osslab.stdoutproblems.batch.BatchImpl

バッチファイルをWebアプリケーション（RMI）経由で実行
-

    $ mvn spring-boot:run


以下にアクセスし、バッチ実行ボタンをクリック:

    http://localhost:8080


停止するには:

  <kbd>CTRL</kbd>+<kbd>C</kbd>をクリック
  

詳細は
-
   
詳細については、このページを参照下さい。
