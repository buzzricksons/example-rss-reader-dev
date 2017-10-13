package service.api;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public interface AbstractService {
    default DIPolicy diPolicy() {
        return DIPolicy.SINGLE;
    }


    public enum DIPolicy {
        SINGLE,
        MULTIPLE
    }

    public static <T> T loadService(Class<T> api) {

        List<T> result = new ArrayList<>();


        ServiceLoader<T> impl = ServiceLoader.load(api);

        for (T loadedImpl : impl) {
            result.add(loadedImpl);
        }

        if (result.isEmpty()) {
            throw new RuntimeException("実装されているクラスが存在しません: " + api);
        }

        return result.get(0);

    }
}
