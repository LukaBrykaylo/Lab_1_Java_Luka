package ua.lviv.iot.algo.part1.lab4.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString(callSuper = true)
public class InkjetPrinter extends Printer {
    public static final int REQUIRED_COLOUR_PER_PAGE = 10;
    public static final String HEADERS = "levelOfCmyk, isCmyk";
    private int levelOfCmyk = 100;
    private boolean isCmyk = true;

    public InkjetPrinter(int levelOfCmyk, boolean isCmyk) {
        this.levelOfCmyk = levelOfCmyk;
        this.isCmyk = isCmyk;
        type = "Inkjet";
    }

    @Override
    public int getRemainingPagesCount() {
        if (!isCmyk) {
            return 0;
        } else {
            return levelOfCmyk / REQUIRED_COLOUR_PER_PAGE;
        }
    }

    @Override
    public String print(final int pages) {
        if (paperCount >= pages && (levelOfCmyk / REQUIRED_COLOUR_PER_PAGE) >= pages) {
            paperCount -= pages;
            levelOfCmyk -= REQUIRED_COLOUR_PER_PAGE * pages;
            return "printed";
        } else {
            return "failed";
        }
    }

    public String getHeaders() {
        return super.getHeaders() + "," + HEADERS;
    }

    public String toCsv() {
        return super.toCsv() + "," + levelOfCmyk + "," + isCmyk;
    }
}
