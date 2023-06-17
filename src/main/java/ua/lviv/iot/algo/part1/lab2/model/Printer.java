package ua.lviv.iot.algo.part1.lab2.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Printer {
    String model = "Modeled";
    String type = "Laser";
    boolean isColor = true;
    boolean isDuplex = false;
    int paperTrayCapacity = 100;
    int paperCount = 0;

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
            paperCount += count;
        }
    }

    public int getRemainingPagesCount(){
        return paperCount;
    }
}
