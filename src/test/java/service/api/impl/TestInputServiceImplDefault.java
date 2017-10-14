package service.api.impl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.api.InputService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestInputServiceImplDefault {
    private final InputService inputService = new InputServiceImplDefault();

    @Test
    @DisplayName("入力したURLがうまく保存されない場合")
    public void testUrl00() {
        assertEquals("https://news.google.com/news/rss/?ned=us&hl=en"
                , inputService.url("https://news.google.com/news/rss/?ned=us&hl=en").get(0)
                , () -> "正常に保存されませんでした。");
    }

    @Test
    @DisplayName("Nullの場合")
    public void testUrl01() {
        assertThrows(NullPointerException.class, () -> inputService.url(null));
    }
}
