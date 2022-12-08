package dyve.aoc2022.day.day7;

public sealed interface File permits Directory, SimpleFile {
    String name();

    int size();
}
