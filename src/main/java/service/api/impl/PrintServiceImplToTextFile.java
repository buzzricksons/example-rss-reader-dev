package service.api.impl;

import lombok.NonNull;
import org.springframework.web.util.HtmlUtils;
import service.api.PrintService;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * RSS Feedをテキストファイルで保存する{@link PrintService}の実装です。
 *
 * @author HyungCheol Kim
 */
public class PrintServiceImplToTextFile implements PrintService {
    /**
     * この実装では引数で受け取ったRSS Feedを{@link HtmlUtils#htmlUnescape(String) UnEscape処理}してTextファイルで保存します。
     * ファイル名はrssFeed_日付の形式でrootディレクトリに保存されます。
     *
     * @param rssFeed RSS Feed
     * @return 出力が成功すれば {@code true}, 失敗すれば{@code false}を返します。
     * @throws FileNotFoundException ファイルが存在しない場合
     */
    @Override
    public boolean print(@NonNull String rssFeed) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime time = LocalDateTime.now();
        String fileName = String.format("rssFeed_%s.txt", time.format(f));
        try (PrintWriter out = new PrintWriter(fileName, "UTF-8")) {
            out.write(HtmlUtils.htmlUnescape(rssFeed));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Textファイルが保存されました。:"+fileName);
        return Boolean.TRUE;
    }
}
