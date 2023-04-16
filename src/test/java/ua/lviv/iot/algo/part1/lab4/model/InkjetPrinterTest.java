package ua.lviv.iot.algo.part1.lab4.model;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class InkjetPrinterTest extends TestCase {

    InkjetPrinter inkjetPrinter;

    @BeforeEach
    public final void setUp() {
        inkjetPrinter = new InkjetPrinter(100, true);
    }

    @Test
    public final void testGetRemainingPagesCount() {
        assertEquals(10, inkjetPrinter.getRemainingPagesCount());
        inkjetPrinter.setCmyk(false);
        assertEquals(0, inkjetPrinter.getRemainingPagesCount());
    }

    @Test
    public final void testPrint() {
        inkjetPrinter.paperCount = 1;
        assertEquals("printed", inkjetPrinter.print(1));
        assertEquals("failed", inkjetPrinter.print(1));
    }
}