package ua.lviv.iot.algo.part1.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class SublimationPrinter extends Printer {
    public static final int REQUIRED_COLOUR_PER_PAGE = 10;
    public static final String HEADERS = "levelOfCmyk, temperature";
    private int levelOfCmyk = 60;
    private int temperature = 0;

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

    @Override
    public int getRemainingPagesCount() {
        if (paperCount > (levelOfCmyk / REQUIRED_COLOUR_PER_PAGE)) {
            return levelOfCmyk / REQUIRED_COLOUR_PER_PAGE;
        } else {
            return paperCount;
        }
    }

    public String getHeaders() {
        return super.getHeaders() + "," + HEADERS;
    }

    public String toCsv() {
        return super.toCsv() + "," + levelOfCmyk + "," + temperature;
    }
}

