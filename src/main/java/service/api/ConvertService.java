package service.api;

/**
 * RSS Feedの変換を表すクラスです。
 *
 * @author HyungCheol Kim
 */
@FunctionalInterface
public interface ConvertService extends AbstractService {
    /**
     * RSS Feedの変換を行い、結果を文字列で返します。
     *
     * @param rssFeed RSS Feed
     * @return 変換されたRSS Feed
     */
    String convert(String rssFeed);
}
