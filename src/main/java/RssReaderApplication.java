import service.operation.Operator;
import service.util.ServiceFactory;

/**
 * RSS Feedを出力するアプリケーションです。
 *
 * @author HyungCheol Kim
 *
 */
public class RssReaderApplication {
    public static void main(String[] args) {
        Operator operator = ServiceFactory.loadSingleDependency(Operator.class);
        operator.execute();
    }
}