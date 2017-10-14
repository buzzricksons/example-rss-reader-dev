package service.api.impl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.api.ConvertService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestConvertServiceImplDefault {
    private final ConvertService convertService = new ConvertServiceImplDefault();

    @Test
    @DisplayName("RSS Feed内容のがうまく置き換えできない場合1")
    public void testConvert00() {
        assertEquals("",convertService.convert("NewsPicks"), () -> "うまく変更できませんでした。");
    }

    @Test
    @DisplayName("RSS Feed内容のがうまく置き換えできない場合2")
    public void testConvert01() {
        assertEquals("",convertService.convert(""), () -> "うまく変更できませんでした。");
    }

    @Test
    @DisplayName("RSS Feed内容のがうまく置き換えできない場合3")
    public void testConvert02() {
        assertEquals("newsPicks",convertService.convert("newsPicks"), () -> "うまく変更できませんでした。");
    }

    @Test
    @DisplayName("Nullを置き換えする場合")
    public void testConvert03() {
        assertThrows(NullPointerException.class, () -> convertService.convert(null));
    }
}
