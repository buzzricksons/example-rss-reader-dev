package service.operation.impl;

import service.api.AcquireService;
import service.api.ConvertService;
import service.api.InputService;
import service.api.PrintService;
import service.operation.Operator;
import service.util.ServiceFactory;

import java.util.Scanner;

/**
 * {@link Operator}のデフォルト実装です。
 * 実行される流れは下記になります。
 * <ul>
 *     <li>1.URLの入力({@link InputService})</li>
 *     <li>2.RSS Feedの取得({@link AcquireService})</li>
 *     <li>3.RSS Feedの加工({@link ConvertService})</li>
 *     <li>4.RSS Feedの出力({@link PrintService})</li>
 * </ul>
 *
 * @author HyungCheol Kim
 */
public class OperatorImplDefaultProxy implements Operator {
    private final InputService inputService =  ServiceFactory.loadSingleDependency(InputService.class);
    private final AcquireService acquireService = ServiceFactory.loadSingleDependency(AcquireService.class);
    private final ConvertService convertService = ServiceFactory.loadSingleDependency(ConvertService.class);
    private final PrintService printService = ServiceFactory.loadSingleDependency(PrintService.class);
    @Override
    public void execute() {
        for (;;) {
            Scanner scan = new Scanner(System.in);
            System.out.println(inputService.message());
            String url = inputService.url(scan.next());

            boolean isExit = url.replaceAll("\\s+","").toUpperCase().equals("X");
            if (isExit) {
                System.out.println("アプリケーションを終了します。");
                break;
            }

            String rssFeed = acquireService.getRssFeed(url);
            String convertedRssFeed = convertService.convert(rssFeed);
            printService.print(convertedRssFeed);
        }
    }
}
