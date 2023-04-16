package ua.lviv.iot.algo.part1.lab4;

import ua.lviv.iot.algo.part1.lab4.model.Printer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrinterWriter {

    public static File file = new File("src\\printer.csv");
    public PrintWriter printWriter;

    public void writeToFile(List<Printer> printers) throws IOException {

        if (printers == null || printers.isEmpty()) {
            return;
        }
        printWriter = new PrintWriter(file);
        Collections.sort(printers, new ComparatorType());
        String previousType = "";
        for (Printer printer : printers) {
            if (!previousType.equals(printer.getType())) {
                previousType = printer.getType();
                printWriter.println(printer.getHeaders());
            }
            printWriter.println(printer.toCsv());
        }

        printWriter.close();
    }

}

class ComparatorType implements Comparator<Printer> {

    @Override
    public int compare(Printer firstPrinter, Printer secondPrinter) {
        return firstPrinter.getType().compareTo(secondPrinter.getType());
    }
}
