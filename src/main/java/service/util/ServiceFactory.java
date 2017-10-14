package service.util;

import service.api.AbstractService;

import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

/**
 * DIするクラスを提供するFactoryクラスです。
 *
 * @author HyungCheol Kim
 */
public class ServiceFactory {
    /**
     * 一つのServiceをロードします。{@link ServiceLoader}を利用します。
     *
     * @param api DI対象のインタフェース
     * @return 実装された一つのDIクラス
     */
    public static <T extends AbstractService> T loadSingleDependency(Class<T> api) {
        List<T> result = _loadDependency(api);
        return result.get(0);
    }

    /**
     * 複数のServiceをロードし不変のリストで返します。{@link ServiceLoader}を利用します。
     *
     * @param api DI対象のインタフェース
     * @return 実装された複数のDIクラス
     */
    public static <T extends AbstractService> List<T> loadMultipleDependency(Class<T> api) {
        return _loadDependency(api);
    }

    private static <T extends AbstractService> List<T> _loadDependency(Class<T> api) {
        ServiceLoader<T> impl = ServiceLoader.load(api);

        List<T> result = impl.stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

        if (result.isEmpty()) {
            throw new RuntimeException("実装されているクラスが存在しません: "+api);
        }

        boolean isValidatedDIPolicy = result.get(0).diPolicy().equals(result.size() > 1 ? AbstractService.DIPolicy.MULTIPLE : AbstractService.DIPolicy.SINGLE);
        if (!isValidatedDIPolicy) {
            throw new RuntimeException("DIできるクラス数の制限を確認してください: "+api);
        }

        return result;
    }
}
