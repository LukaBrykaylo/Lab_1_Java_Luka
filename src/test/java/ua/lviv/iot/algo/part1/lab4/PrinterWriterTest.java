package ua.lviv.iot.algo.part1.lab4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ua.lviv.iot.algo.part1.lab4.model.InkjetPrinter;
import ua.lviv.iot.algo.part1.lab4.model.LaserPrinter;
import ua.lviv.iot.algo.part1.lab4.model.MatrixPrinter;
import ua.lviv.iot.algo.part1.lab4.model.Printer;
import ua.lviv.iot.algo.part1.lab4.model.SublimationPrinter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrinterWriterTest {

    private static final String RESULT_FILENAME = "src\\expected.csv";
    private static final String ACTUAL_FILENAME = "src\\printer.csv";
    public PrinterWriter printerWriter;
    public List<Printer> printers;
    public List<Printer> printerstest;
    public File expectedFile;
    public File actualFile;

    @BeforeEach
    public final void setUp() throws IOException {
        printerWriter = new PrinterWriter();
        expectedFile = new File(RESULT_FILENAME);
        printers = new ArrayList<>();
        printers.add(new SublimationPrinter(400, 0));
        printers.add(new MatrixPrinter(24, true, 100));
        printers.add(new InkjetPrinter(250, true));
        printers.add(new LaserPrinter(4, 0));
        printers.add(new InkjetPrinter(200, false));
        printers.add(new LaserPrinter(110, 5));
        Files.deleteIfExists(Path.of(printerWriter.file.getPath()));

        printerstest = new ArrayList<>();
        printerstest.add(new LaserPrinter(2000, 1000));
    }

    @AfterAll
    public void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(ACTUAL_FILENAME));
    }

    @Test
    public final void testPrintToFile() throws IOException {
        printerWriter.writeToFile(printers);
        Path path1 = printerWriter.file.toPath();
        Path path2 = expectedFile.toPath();
        Assertions.assertEquals(-1L, Files.mismatch(path1, path2));
    }

    @Test
    public final void testIsFileEmpty() throws IOException {
        printerWriter.writeToFile(null);
        Assertions.assertFalse(printerWriter.file.exists());
    }

    @Test
    public final void testDublicateFile() throws IOException {
        printerWriter.writeToFile(printerstest);
        printerWriter.writeToFile(printers);
        Path path1 = printerWriter.file.toPath();
        Path path2 = expectedFile.toPath();
        Assertions.assertEquals(-1L, Files.mismatch(path1, path2));
    }

}
