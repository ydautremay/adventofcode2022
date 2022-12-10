package dyve.aoc2022.day.day10;

public final class Noop implements Command {

    @Override
    public State execute(Register register) {
        return State.DONE;
    }

    @Override
    public String toString() {
        return "noop";
    }
}
