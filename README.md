**KIM RSS Reader**
# 仕様
入力されたURLからRSS Feedを取得して加工した後、出力します。

# 開発者マニュアル

## DI(Dependency Injection)
- [ServiceLoader](https://docs.oracle.com/javase/6/docs/api/java/util/ServiceLoader.html)を利用して実装されています。
- 拡張可能な5種類のインタフェースがあります。

## 拡張可能な5種類のインターフェース
### InputService
URLの入力を行います。

### AcquireService
URLからRSS Feedを取得する処理を行います。

### ConvertService
RSS Feedの加工処理を行います。

### PrintService
RSS Feedの出力を行います。

### Operator
RSS Readerアプリケーションの実行を行います。

## DIの新規追加
1. 5種類のDIの中で拡張するDIをimplementします。
2. `/resources/META-INF/services`に入っている設定ファイルの中身を1番でimplementしたクラスに変更します。

## DIの変更
`/resources/META-INF/services`に入っている設定ファイルの中身を変更したいDIで設定します。

## その他
- JDK 9をインストールする必要があります。
- lombokを利用するためIntelliJの場合は下記の設定が必要です。
    - https://qiita.com/abetd/items/c586ca375fb1b9e4145a

---
Created by [HyungCheol Kim](https://sites.google.com/site/hcgoon/)
