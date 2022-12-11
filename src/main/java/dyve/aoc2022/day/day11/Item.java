package dyve.aoc2022.day.day11;

import java.math.BigInteger;

public class Item {

    private BigInteger worry;

    public Item(int worry) {
        this.worry = BigInteger.valueOf(worry);
    }

    public BigInteger getWorry() {
        return worry;
    }

    public void setWorry(BigInteger worry) {
        this.worry = worry;
    }
}
