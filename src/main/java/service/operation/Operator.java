package service.operation;

import service.api.AbstractService;

/**
 * アプリケーションの実行を表すインタフェースです。
 *
 * @author HyungCheol Kim
 */
@FunctionalInterface
public interface Operator extends AbstractService {
    /**
     * オペレーションを行います。
     *
     * @throws Exception オペレーション実行中にエラーが起きる場合
     */
    void execute();
}
