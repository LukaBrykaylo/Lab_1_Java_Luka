package ua.lviv.iot.algo.part1.lab3.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Printer {
    protected String model = "Modeled";
    protected String type = "Laser";
    protected boolean isColor = true;
    protected boolean isDuplex = false;
    protected int paperTrayCapacity = 100;
    protected int paperCount = 0;

    public String print(final int pages) {
        if (paperCount >= pages) {
            System.out.println("Printing...");
            paperCount -= pages;
        } else {
            System.out.println("Need more paper.");
        }
        return null;
    }

    public void loadPaper(final int count) {
        if ((paperCount + count) > paperTrayCapacity) {
            System.out.println("loaded: " + (paperTrayCapacity - paperCount) + " papers.");
            paperCount = paperTrayCapacity;
        } else {
            paperCount += count;
        }
    }

    public int getRemainingPagesCount() {
        return paperCount;
    }
}

