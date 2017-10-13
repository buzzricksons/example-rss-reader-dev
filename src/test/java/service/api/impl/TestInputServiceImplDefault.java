package service.api.impl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.api.InputService;

import static org.junit.jupiter.api.Assertions.*;

public class TestInputServiceImplDefault {
    private final InputService acquireService = new InputServiceImplDefault();

    @Test
    @DisplayName("RSS Feedが空の結果の場合")
    public void testGetRssFeed00() {
        assertEquals(2, 1 + 1);
        assertTrue(!acquireService.getRssFeed("https://news.google.com/news/rss/?ned=us&hl=en").isEmpty()
                , () -> "取得したRSS Feedが存在しません。");

    }

    @Test
    @DisplayName("間違えたFeed URLの場合")
    public void testGetRssFeed01() {
        assertThrows(RuntimeException.class, () -> acquireService.getRssFeed("1"));
    }
}
