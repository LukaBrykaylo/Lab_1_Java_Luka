package ua.lviv.iot.algo.part1.lab3.model;

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
public class InkjetPrinter extends Printer {
    public static final int REQUIRED_COLOUR_PER_PAGE = 10;
    private int levelOfCmyk = 100;
    private boolean isCmyk = true;

    @Override
    public int getRemainingPagesCount() {
        if (isCmyk == false) {
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
}
