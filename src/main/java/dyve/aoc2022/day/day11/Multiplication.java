package dyve.aoc2022.day.day11;

import java.math.BigInteger;

public class Multiplication implements Operation {

    private final BigInteger base;

    public Multiplication(BigInteger base) {
        this.base = base;
    }

    @Override
    public BigInteger compute(BigInteger input) {
        return base.multiply(input);
    }
}
