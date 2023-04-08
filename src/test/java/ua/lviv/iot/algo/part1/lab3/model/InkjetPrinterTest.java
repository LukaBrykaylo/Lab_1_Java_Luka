package ua.lviv.iot.algo.part1.lab3.model;

import junit.framework.TestCase;
import org.junit.Test;

public class InkjetPrinterTest extends TestCase {

    InkjetPrinter inkjetPrinter = new InkjetPrinter(100,true);
    InkjetPrinter testInkjetPrinter2 = new InkjetPrinter();
    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(10, inkjetPrinter.getRemainingPagesCount());
        inkjetPrinter.setCMYK(false);
        assertEquals(0, inkjetPrinter.getRemainingPagesCount());
    }

    @Test
    public void testPrint() {
        inkjetPrinter.paperCount = 1;
        assertEquals("printed", inkjetPrinter.print(1));
        assertEquals("failed", inkjetPrinter.print(1));
    }
}