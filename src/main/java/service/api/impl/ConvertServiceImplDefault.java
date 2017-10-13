package service.api.impl;

import lombok.NonNull;
import service.api.AbstractService;
import service.api.ConvertService;

public class ConvertServiceImplDefault implements ConvertService, AbstractService {
    @Override
    public String convert(@NonNull String rssFeed) {
        return rssFeed.replace("NewsPicks","");
    }
}