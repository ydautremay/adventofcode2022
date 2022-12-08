package dyve.aoc2022.day.day7;

import java.util.*;
import java.util.stream.Collectors;

public final class Directory implements File {

    UUID id;

    String name;

    int size = -1;

    Directory parent;

    Set<File> content;

    public Directory(String name, Directory parent) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.parent = parent;
        this.content = new HashSet<>();
    }

    @Override
    public String name() {
        return name;
    }

    public int size(){
        if(size == -1){
            size = content.stream().mapToInt(File::size).sum();
        }
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Directory directory = (Directory) o;
        return id.equals(directory.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Directory{" +
                "name='" + name + '\'' +
                ", content=" + content.stream().map(File::name).collect(Collectors.joining(",")) +
                '}';
    }

    Optional<Directory> directoryByName(String name){
        return content.stream().filter(Directory.class::isInstance).map(Directory.class::cast).filter(d -> d.name().equals(name)).findFirst();
    }
}
