package service.api.impl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.api.ConvertService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestConvertServiceImplEscape {
    private final ConvertService convertService = new ConvertServiceImplUnEscape();

    @Test
    @DisplayName("RSS Feed内容のがうまく置き換えできない場合1")
    public void testConvert00() {
        assertEquals("<h2>",convertService.convert("&lt;h2&gt;"), () -> "うまく変更できませんでした。");
    }

    @Test
    @DisplayName("RSS Feed内容のがうまく置き換えできない場合2")
    public void testConvert01() {
        assertEquals("",convertService.convert(""), () -> "うまく変更できませんでした。");
    }

    @Test
    @DisplayName("Nullを置き換えする場合")
    public void testConvert02() {
        assertThrows(NullPointerException.class, () -> convertService.convert(null));
    }
}
