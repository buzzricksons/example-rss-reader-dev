package service.api;

/**
 * URLからのRSS Feedを取得を表すクラスです。
 *
 * @author HyungCheol Kim
 */
@FunctionalInterface
public interface AcquireService extends AbstractService {
    /**
     * URLからRSS Feedを取得します。
     *
     * @param url URL
     * @return 取得したRSS Feed
     */
    String getRssFeed(String url);
}
