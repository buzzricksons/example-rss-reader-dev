package service.api.impl;

import lombok.NonNull;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import service.api.AbstractService;
import service.api.AcquireService;

import java.io.IOException;

public class AcquireServiceImplDefault implements AcquireService, AbstractService {
    @Override
    public String getRssFeed(@NonNull String url) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
//            response.getStatusLine().getStatusCode();//TODO responseが200ではない場合のハンドリング
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Can not find rss.");
    }
}
