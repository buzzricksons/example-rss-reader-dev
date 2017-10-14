**KIM RSS Reader**
FeedのURLがレポジトリに上がらないようにURLを標準入力で直接入れる実装をしました。

# 提出物
Rootディレクトリの`提出物`フォルダーに入っています。

# 仕様
入力されたURLからRSS Feedを取得して加工した後、出力します。

* 複数のRSS FEEDのURL入力が可能です。
* RSS FEEDは標準出力とTextファイルの保存、両方実行されます。

# 開発者マニュアル
## jarファイルの作成
Mavenで下記のコマンドを実行するとjarファイルが作られます。
```
clean compile assembly:single
```
build成果物は`kim-rss-reader-1.0.0-SNAPSHOT-jar-with-dependencies`のファイル名で生成されます。
> build途中lombokによるエラーが起きますが、成果物は作成されます。

## jarファイルの実行
```
$ java -jar kim-rss-reader-1.0.0-SNAPSHOT-jar-with-dependencies
```

## DI(Dependency Injection)
* [ServiceLoader](https://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html)を利用して実装されています。
* 拡張可能な5種類のインタフェースがあります。

### 拡張可能な5種類のインターフェース
#### 1.InputService
URLの入力を行います。

* `InputServiceImplDefault`: InputServiceのデフォルト実装です。
* `InputServiceImplMultiple`: 複数RSS対応の実装です。

#### 2.AcquireService
URLからRSS Feedを取得する処理を行います。

* `AcquireServiceImplDefault`: AcquireServiceのデフォルト実装です。

#### 3.ConvertService
RSS Feedの加工処理を行います。

* `ConvertServiceImplDefault`: ConvertServiceのデフォルト実装です。
* `ConvertServiceImplUnEscape`: RSS Feedの内容にHtmlUnescape処理をする実装です。

#### 4.PrintService
RSS Feedの出力を行います。

* `PrintServiceImplDefault`: PrintServiceのデフォルト実装です。
* `PrintServiceImplToTextFile`: RSS FeedをTextファイルで保存する実装です。

#### 5.Operator
RSS Readerアプリケーションの実行を行います。

* `OperatorImplDefaultProxy`: Operatorのデフォルト実装です。
* `OperatorImpl2ndPhase`: 複数RSS対応およびRss Feedの標準出力とTextファイルの保存が追加された実装です。

### DIの新規追加
1. 5種類のDIの中で拡張するDIをimplementします。
2. `/resources/META-INF/services`に入っている設定ファイルの中身を1番でimplementしたクラスに変更します。

### DIの変更
`/resources/META-INF/services`に入っている設定ファイルの中身を変更したいDIで設定します。

## その他
* JDK 9をインストールする必要があります。
* lombokを利用するためIntelliJの場合は下記の設定が必要です。
    * https://qiita.com/abetd/items/c586ca375fb1b9e4145a

***
Created by [HyungCheol Kim](https://sites.google.com/site/hcgoon/)
