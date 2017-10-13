package service.api;

import java.util.List;

/**
 * RSSのURLを持っているクラスです。
 *
 * @author HyungCheol Kim
 */
public interface InputService {
    /**
     * URLを入力する時、表示されるメッセージです。
     *
     * @return メッセージ
     */
    String message();

    /**
     * URLを持っているリストを返します。
     *
     * @param url 入力したURL
     * @return URLのリスト
     */
    String url(String url);
}
