package service.api.impl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.api.InputService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestInputServiceImplMultiple {
    private final InputService inputService = new InputServiceImplMultiple();

    @Test
    @DisplayName("入力したURLがうまく保存されない場合")
    public void testUrl00() {
        assertEquals(2, inputService.url("https://news.google.com/news/rss/?ned=us&hl=en,https://news.google.com/news/rss/?ned=us&hl=en").size());
    }

    @Test
    @DisplayName("入力したURLがうまくparsingされない場合")
    public void testUrl01() {
        assertEquals("https://news.google.com/news/rss/?ned=us&hl=en"
                , inputService.url("https://news.google.com/news/rss/?ned=us&hl=en,https://news.google.com/news/rss/?ned=us&hl=en").get(0));
    }

    @Test
    @DisplayName("Nullの場合")
    public void testUrl02() {
        assertThrows(NullPointerException.class, () -> inputService.url(null));
    }
}
