package service.api.impl;

import lombok.NonNull;
import service.api.InputService;

import java.util.Arrays;
import java.util.List;

/**
 * {@link InputService}の複数URL対応実装です。
 *
 * @author HyungCheol Kim
 */
public class InputServiceImplMultiple implements InputService {
    @Override
    public String message() {
        return ">RSSのURLを入力してください。複数の場合はカンマ区切りで、空白は入れないでください。(終了する場合はxを入力してください。)：";
    }

    /**
     * この実装では複数のURLが入っている不変のリストを返します。
     * @param url 入力したURL
     * @return URLが入っているリスト
     */
    @Override
    public List<String> url(@NonNull String url) {
        return Arrays.asList(url.split("\\s*,\\s*"));
    }
}
