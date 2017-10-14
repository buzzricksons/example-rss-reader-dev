package service.api;

/**
 * 各サービス共通のルールを定義するインターフェースです。
 *
 * @author HyungCheol Kim
 */
public interface AbstractService {
    /**
     * サービスごとのDIルールをで定義します。
     * デフォルトは一つのDIのみ利用可能というルールです。
     *
     * @return 一つのみのDIの場合は {@link DIPolicy#SINGLE}、複数のDIの場合は {@link DIPolicy#MULTIPLE}
     */
    default DIPolicy diPolicy() {
        return DIPolicy.SINGLE;
    }

    public enum DIPolicy {
        /**
         * 一つのみのDIが利用可能です。
         */
        SINGLE,
        /**
         * 複数のDIが利用可能です。
         */
        MULTIPLE
    }
}
