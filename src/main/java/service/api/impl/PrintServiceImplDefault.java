package service.api.impl;

import lombok.NonNull;
import service.api.PrintService;

/**
 * {@link PrintService}のデフォルト実装です。
 *
 * @author HyungCheol Kim
 */
public class PrintServiceImplDefault implements PrintService {
    /**
     * この実装では引数で受け取ったRSS Feedをそのまま標準出力します。
     *
     * @param rssFeed RSS Feed
     * @return 出力が成功すれば {@code true}, 失敗すれば{@code false}を返します。
     */
    @Override
    public boolean print(@NonNull String rssFeed) {
        System.out.println(rssFeed);
        return Boolean.TRUE;
    }
}
