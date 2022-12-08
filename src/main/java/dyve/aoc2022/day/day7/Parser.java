package dyve.aoc2022.day.day7;

import dyve.aoc2022.input.InputReader;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

public class Parser {

    private static final Pattern cdPattern = Pattern.compile("\\$ cd (.+)");

    private static final Pattern dirPattern = Pattern.compile("dir (.+)");

    private static final Pattern filePattern = Pattern.compile("(\\d+) (.+)");

    public static Set<Directory> parse(InputReader reader){
        Set<Directory> directories = new HashSet<>();
        AtomicReference<Directory> workdir = new AtomicReference<>();
        reader.stream().forEach(s -> {
            cdPattern.matcher(s).results().map(m -> m.group(1)).findFirst().ifPresent(r -> {
                if("..".equals(r)){
                    workdir.set(workdir.get().parent == null ? workdir.get() : workdir.get().parent);

                } else if("/".equals(r)){
                    workdir.set(new Directory("/", null));
                    directories.add(workdir.get());
                } else {
                    workdir.set(workdir.get().directoryByName(r).orElseThrow());
                }
            });
            dirPattern.matcher(s).results().map(m -> m.group(1)).findFirst().ifPresent(r -> {
                Directory d = new Directory(r, workdir.get());
                directories.add(d);
                workdir.get().content.add(d);

            });
            filePattern.matcher(s).results().findFirst().ifPresent(r -> {
                SimpleFile f = new SimpleFile(r.group(2), Integer.parseInt(r.group(1)));
                workdir.get().content.add(f);
            });
        });
        return directories;
    }
}
