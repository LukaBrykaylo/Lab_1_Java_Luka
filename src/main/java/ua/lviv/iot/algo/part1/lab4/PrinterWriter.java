package ua.lviv.iot.algo.part1.lab4;

import ua.lviv.iot.algo.part1.lab4.model.Printer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrinterWriter {

    public static final File file = new File("src\\printer.csv");

    public void writeToFile(List<Printer> printers) {

        if (printers == null || printers.isEmpty()) {
            return;
        }
        try (PrintWriter printWriter = new PrintWriter(file, StandardCharsets.UTF_8)) {
            Collections.sort(printers, new ComparatorType());
            String previousType = "";
            for (Printer printer : printers) {
                if (!previousType.equals(printer.getClass().getSimpleName())) {
                    previousType = printer.getClass().getSimpleName();
                    printWriter.println(printer.getHeaders());
                }
                printWriter.println(printer.toCsv());
            }
        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

}

class ComparatorType implements Comparator<Printer>, Serializable {

    @Override
    public int compare(Printer firstPrinter, Printer secondPrinter) {
        return firstPrinter.getClass().getSimpleName().compareTo(secondPrinter.getClass().getSimpleName());
    }
}
