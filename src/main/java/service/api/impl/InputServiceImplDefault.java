package service.api.impl;

import lombok.NonNull;
import service.api.InputService;

/**
 * {@link InputService}のデフォルト実装です。
 *
 * @author HyungCheol Kim
 */
public class InputServiceImplDefault implements InputService {
    @Override
    public String message() {
        return ">RSSのURLを一つ入力してください(終了する場合はxを入力してください。)：";
    }

    /**
     * この実装では一つのURLが入っている不変のリストを返します。
     * @param url 入力したURL
     * @return
     */
    @Override
    public String url(@NonNull String url) {
        return url;
    }
}
