package ua.lviv.iot.algo.part1.lab3.model;

import junit.framework.TestCase;
import org.junit.Test;

public class MatrixPrinterTest extends TestCase {

    MatrixPrinter matrixPrinter = new MatrixPrinter(24,true,100);
    MatrixPrinter testMatrixPrinter = new MatrixPrinter();
    @Test
    public void testPrint() {
        matrixPrinter.paperCount = 1;
        assertEquals("printed", matrixPrinter.print(1));
        assertEquals("failed", matrixPrinter.print(4));
        matrixPrinter.loadPaper(900);
    }

    @Test
    public void testGetRemainingPagesCount() {
        assertEquals(0,matrixPrinter.getRemainingPagesCount());
        matrixPrinter.setPaperCount(500);
        assertEquals(10,matrixPrinter.getRemainingPagesCount());
    }
}