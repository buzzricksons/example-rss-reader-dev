package service.api.impl;

import lombok.NonNull;
import service.api.ConvertService;

/**
 * {@link ConvertService}のデフォルト実装です。
 *
 * @author HyungCheol Kim
 *
 */
public class ConvertServiceImplDefault implements ConvertService {
    private final String TARGET = "<body>";
    /**
     * この実装では {@link #TARGET}を取り除く処理を行います。
     *
     * @param rssFeed RSS Feed
     * @return {@link #TARGET}を取り除いたRSS Feed
     */
    @Override
    public String convert(@NonNull String rssFeed) {
        return rssFeed.replace(TARGET,"");
    }
}