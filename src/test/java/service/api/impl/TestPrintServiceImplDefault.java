package service.api.impl;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.api.PrintService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestPrintServiceImplDefault {
    private final PrintService printService = new PrintServiceImplDefault();

    @Test
    @DisplayName("RSS Feedの出力が失敗した場合")
    public void testUrl00() {
        assertEquals(Boolean.TRUE, printService.print("<span>Hello World.</span>"));
    }

    @Test
    @DisplayName("Nullの場合")
    public void testUrl01() {
        assertThrows(NullPointerException.class, () -> printService.print(null));
    }
}
