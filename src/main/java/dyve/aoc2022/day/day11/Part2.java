package dyve.aoc2022.day.day11;

import dyve.aoc2022.day.Part;
import dyve.aoc2022.input.InputReader;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(11);
    }

    @Override
    protected Object execute(InputReader reader) {
        List<Monkey> monkeys = MonkeyReader.read(reader);
        BigInteger commonMultiple = BigInteger.valueOf(monkeys.stream().mapToInt(Monkey::getDivisor).reduce((a, b) -> a * b).orElseThrow());
        for(int i = 1; i <= 10_000; i++){
            for(Monkey monkey : monkeys) {
                while (monkey.hasItem()) {
                    Item item = monkey.examine();
                    item.setWorry(item.getWorry().mod(commonMultiple));
                    monkey.throwItem(item);
                }
            }
        }

        return monkeys.stream()
                .sorted(Comparator.comparing(Monkey::getActivity).reversed())
                .map(Monkey::getActivity)
                .limit(2)
                .reduce(BigInteger::multiply)
                .orElseThrow();
    }
}
