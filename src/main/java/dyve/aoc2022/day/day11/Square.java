package dyve.aoc2022.day.day11;

import java.math.BigInteger;

public class Square implements Operation{
    @Override
    public BigInteger compute(BigInteger input) {
        return input.pow(2);
    }
}
