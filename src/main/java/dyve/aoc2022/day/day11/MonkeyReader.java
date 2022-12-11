package dyve.aoc2022.day.day11;

import dyve.aoc2022.input.InputReader;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MonkeyReader {

    public static List<Monkey> read(InputReader reader){
        List<Monkey> monkeys = new ArrayList<>();
        List<MonkeyBuilder> monkeyBuilders = new ArrayList<>();
        AtomicReference<MonkeyBuilder> currentMonkeyBuilder = new AtomicReference<>();
        reader.stream().forEach(s -> {
            if(s.isBlank()){
                return;
            }
            if(s.startsWith("Monkey")){
                currentMonkeyBuilder.set(new MonkeyBuilder());
                return;
            }
            if(s.startsWith("  Starting")){
                String[] vals = s.substring(18).split(", ");
                currentMonkeyBuilder.get().getItems().addAll(Arrays.stream(vals).map(e -> new Item(Integer.parseInt(e))).toList());
                return;
            }
            if(s.startsWith("  Operation")){
                String strValue = s.substring(25);
                Operation operation;
                if(s.charAt(23) == '+'){
                    operation = new Addition(new BigInteger(strValue));
                }else{
                    if(strValue.equals("old")){
                        operation = new Square();
                    }else {
                        operation = new Multiplication(new BigInteger(strValue));
                    }
                }
                currentMonkeyBuilder.get().setOperation(operation);
                return;
            }
            if(s.startsWith("  Test")){
                int divisor = Integer.parseInt(s.substring(21));
                currentMonkeyBuilder.get().setDivisor(divisor);
                return;
            }
            if(s.startsWith("    If true")){
                int trueMonkey = Integer.parseInt(s.substring(29));
                currentMonkeyBuilder.get().setMonkeyIfTrue(trueMonkey);
                return;
            }
            if(s.startsWith("    If false")){
                int falseMonkey = Integer.parseInt(s.substring(30));
                currentMonkeyBuilder.get().setMonkeyIfFalse(falseMonkey);
                monkeyBuilders.add(currentMonkeyBuilder.get());
                monkeys.add(currentMonkeyBuilder.get().build());
            }
        });
        for(int i = 0; i < monkeys.size(); i++){
            monkeys.get(i).setMonkeyIfFalse(monkeys.get(monkeyBuilders.get(i).getMonkeyIfFalse()));
            monkeys.get(i).setMonkeyIfTrue(monkeys.get(monkeyBuilders.get(i).getMonkeyIfTrue()));
        }
        return monkeys;
    }

    private static class MonkeyBuilder{

        private final List<Item> items = new ArrayList<>();

        private Operation operation;

        private int divisor;

        private int monkeyIfTrue;
        private int monkeyIfFalse;

        public List<Item> getItems() {
            return items;
        }

        public Operation getOperation() {
            return operation;
        }

        public void setOperation(Operation operation) {
            this.operation = operation;
        }

        public int getDivisor() {
            return divisor;
        }

        public void setDivisor(int divisor) {
            this.divisor = divisor;
        }

        public int getMonkeyIfTrue() {
            return monkeyIfTrue;
        }

        public void setMonkeyIfTrue(int monkeyIfTrue) {
            this.monkeyIfTrue = monkeyIfTrue;
        }

        public int getMonkeyIfFalse() {
            return monkeyIfFalse;
        }

        public void setMonkeyIfFalse(int monkeyIfFalse) {
            this.monkeyIfFalse = monkeyIfFalse;
        }

        public Monkey build(){
            return new Monkey(getItems(), getOperation(), getDivisor());
        }
    }
}
