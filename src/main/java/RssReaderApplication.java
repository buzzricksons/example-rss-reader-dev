import service.api.*;

import java.util.Scanner;

public class RssReaderApplication {
    public static final InputService inputService = AbstractService.loadService(InputService.class);
    public static final AcquireService acquireService = AbstractService.loadService(AcquireService.class);
    public static final ConvertService convertService = AbstractService.loadService(ConvertService.class);
    public static final PrintService printService = AbstractService.loadService(PrintService.class);
    public static void main(String[] args) {
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
