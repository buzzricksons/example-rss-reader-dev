package service.api;

/**
 * RSS Feedの出力を表すクラスです。
 *
 * @author HyungCheol Kim
 */
@FunctionalInterface
public interface PrintService extends AbstractService {
    /**
     * RSS Feedを出力します。
     *
     * @param rssFeed RSS Feed
     * @return 出力が成功すれば {@code true}, 失敗すれば{@code false}を返します。
     */
    boolean print(String rssFeed);
}
