package service.api.impl;

import lombok.NonNull;
import org.springframework.web.util.HtmlUtils;
import service.api.ConvertService;

/**
 * escape処理を加えた{@link ConvertService}の実装です。
 *
 * @author HyungCheol Kim
 *
 */
public class ConvertServiceImplUnEscape implements ConvertService {
    /**
     * この実装では{@link HtmlUtils#htmlEscape(String)}処理をして返します。
     *
     * @param rssFeed RSS Feed
     * @return escape処理したRSS Feed
     */
    @Override
    public String convert(@NonNull String rssFeed) {
        return HtmlUtils.htmlUnescape(rssFeed);
    }
}