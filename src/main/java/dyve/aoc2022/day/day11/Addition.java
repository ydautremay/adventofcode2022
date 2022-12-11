package dyve.aoc2022.day.day11;

import java.math.BigInteger;

public class Addition implements Operation{

    private final BigInteger base;

    public Addition(BigInteger base) {
        this.base = base;
    }

    @Override
    public BigInteger compute(BigInteger input) {
        return base.add(input);
    }
}
