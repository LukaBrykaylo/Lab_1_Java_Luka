package ua.lviv.iot.algo.part1.lab3.model;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class MatrixPrinterTest extends TestCase {

    MatrixPrinter matrixPrinter;

    @BeforeEach
    public final void setUp() {
        matrixPrinter = new MatrixPrinter(24, true, 100);
    }

    @Test
    public final void testPrint() {
        matrixPrinter.paperCount = 1;
        assertEquals("printed", matrixPrinter.print(1));
        assertEquals("failed", matrixPrinter.print(4));
        matrixPrinter.loadPaper(900);
    }

    @Test
    public final void testGetRemainingPagesCount() {
        assertEquals(0, matrixPrinter.getRemainingPagesCount());
        matrixPrinter.setPaperCount(500);
        assertEquals(10, matrixPrinter.getRemainingPagesCount());
    }
}