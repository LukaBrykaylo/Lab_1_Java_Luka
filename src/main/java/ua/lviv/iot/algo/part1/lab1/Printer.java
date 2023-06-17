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
            paperCount -= pages;
        }
    }

    public void loadPaper(int count) {
        if ((paperCount + count) > paperTrayCapacity) {
            paperCount = paperTrayCapacity;
        } else {;
            paperCount += count;
        }
    }

    public static Printer getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        Printer p1 = new Printer();
        Printer p2 = new Printer("Epson", "Ink", true, true, 150, 10);
        Printer p3 = getInstance();
        Printer p4 = getInstance();
        Printer[] printers = {p1, p2, p3, p4};
        for (Printer show: printers) {
            System.out.println(show);
        }
    }
}
