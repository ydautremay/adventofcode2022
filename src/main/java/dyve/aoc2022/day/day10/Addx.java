package dyve.aoc2022.day.day10;

public final class Addx implements Command {

    private final int value;

    private State state = State.DONE;

    private Addx(int value){
        this.value = value;
    }

    public static Addx withValue(int v){
        return new Addx(v);
    }

    @Override
    public State execute(Register register) {
        state =  switch (state){
            case DONE -> State.WORKING;
            case WORKING -> {
                register.setValue(register.value() + value);
                yield  State.DONE;
            }
        };
        return state;
    }

    @Override
    public String toString() {
        return "addx " + value;
    }
}
