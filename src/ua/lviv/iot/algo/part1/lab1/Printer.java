package ua.lviv.iot.algo.part1.lab1;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Printer {
    String model = "Modeled";
    String type = "Laser";
    boolean isColor = true;
    boolean isDuplex = false;
    int paperTrayCapacity = 100;
    int paperCount = 0;
    static Printer instance = new Printer();

    public void print(int pages) {
        if (paperCount >= pages) {
            System.out.println("Printing...");
            paperCount -= pages;
        } else {
            System.out.println("Need more paper.");
        }
    }

    public void loadPaper(int count) {
        if ((paperCount + count) > paperTrayCapacity) {
            System.out.println("loaded: " + (paperTrayCapacity - paperCount) + " papers.");
            paperCount = paperTrayCapacity;
        } else {
            System.out.println("All paper loaded.");
            paperCount += count;
        }
    }

    public static Printer getInstance() {
        return instance;
    }

    public String toString() {
        return "Model[" + model + "], Type[" + type + "], isColor[" + isColor + "], isDuplex[" + isDuplex
                + "], paperTrayCapacity[" + paperTrayCapacity + "], paperCount[" + paperCount + "]";
    }

    public static void main(String[] args) {
        Printer p1 = new Printer();
        Printer p2 = new Printer("Epson", "Ink", true, true, 150, 10);
        Printer p3 = getInstance();
        Printer p4 = getInstance();
        Printer[] printers = {p1, p2, p3, p4};
        System.out.println(p2);
        p2.print(10);
        p2.loadPaper(222);
        System.out.println(p2);
        System.out.println("------------------------------------------------------------------------------------------");
        int count = printers.length;
        while (count > 0) {
            System.out.println(printers[count - 1]);
            count--;
        }
    }
}
