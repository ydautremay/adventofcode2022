package dyve.aoc2022.day.day11;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Monkey {

    private final Deque<Item> items = new ArrayDeque<>();

    private final Operation operation;

    private final int divisor;

    private Monkey monkeyIfTrue;

    private Monkey monkeyIfFalse;

    private BigInteger activity = BigInteger.ZERO;

    public Monkey(List<Item> items, Operation operation, int divisor) {
        this.items.addAll(items);
        this.operation = operation;
        this.divisor = divisor;
    }

    public void setMonkeyIfTrue(Monkey monkeyIfTrue) {
        this.monkeyIfTrue = monkeyIfTrue;
    }

    public void setMonkeyIfFalse(Monkey monkeyIfFalse) {
        this.monkeyIfFalse = monkeyIfFalse;
    }

    public int getDivisor() {
        return divisor;
    }

    public Item examine(){
        activity = activity.add(BigInteger.ONE);
        Item item = items.removeFirst();
        item.setWorry(operation.compute(item.getWorry()));
        return item;
    }

    public boolean hasItem(){
        return !items.isEmpty();
    }

    public void throwItem(Item item){
        if (item.getWorry().mod(BigInteger.valueOf(divisor)).equals(BigInteger.ZERO)) {
            monkeyIfTrue.receiveItem(item);
        } else {
            monkeyIfFalse.receiveItem(item);
        }
    }

    public void receiveItem(Item item){
        items.addLast(item);
    }

    public BigInteger getActivity() {
        return activity;
    }
}
