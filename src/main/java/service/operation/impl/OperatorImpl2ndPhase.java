package service.operation.impl;

import service.api.AcquireService;
import service.api.ConvertService;
import service.api.InputService;
import service.api.PrintService;
import service.operation.Operator;
import service.util.ServiceFactory;

import java.util.List;
import java.util.Scanner;

/**
 * {@link Operator}の2次フェーズ実装です。
 * 実行される流れは下記になります。
 * <ul>
 *     <li>1.URLの入力(複数入力も可能)({@link service.api.impl.InputServiceImplMultiple})</li>
 *     <li>2.RSS Feedの取得({@link service.api.impl.AcquireServiceImplDefault})</li>
 *     <li>3.RSS Feedの加工({@link service.api.impl.ConvertServiceImplDefault})</li>
 *     <li>4.RSS Feedの出力(標準出力とTextファイルの保存両方実行します。)({@link service.api.impl.PrintServiceImplDefault}, {@link service.api.impl.PrintServiceImplToTextFile})</li>
 * </ul>
 *
 * @author HyungCheol Kim
 */
public class OperatorImpl2ndPhase implements Operator {
    private final InputService inputService =  ServiceFactory.loadSingleDependency(InputService.class);
    private final AcquireService acquireService = ServiceFactory.loadSingleDependency(AcquireService.class);
    private final ConvertService convertService = ServiceFactory.loadSingleDependency(ConvertService.class);
    private final List<PrintService> printService = ServiceFactory.loadMultipleDependency(PrintService.class);
    @Override
    public void execute() {
        for (;;) {
            Scanner scan = new Scanner(System.in);
            System.out.println(inputService.message());
            String url = scan.next();
            boolean isExit = url.replaceAll("\\s+","").toUpperCase().equals("X");
            if (isExit) {
                System.out.println("アプリケーションを終了します。");
                break;
            }
            inputService.url(url)
                    .stream()
                    .forEach(seperatedUrl -> {
                        String rssFeed = acquireService.getRssFeed(seperatedUrl);
                        String convertedRssFeed = convertService.convert(rssFeed);
                        printService.stream()
                                .forEach(p -> p.print(convertedRssFeed));
                    });
        }
    }
}
