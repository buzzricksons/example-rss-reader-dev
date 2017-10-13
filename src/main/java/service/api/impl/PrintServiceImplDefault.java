package service.api.impl;

import lombok.NonNull;
import service.api.AbstractService;
import service.api.PrintService;

public class PrintServiceImplDefault implements PrintService, AbstractService {
    @Override
    public void print(@NonNull String rssFeed) {
        System.out.println(rssFeed);
    }
}
