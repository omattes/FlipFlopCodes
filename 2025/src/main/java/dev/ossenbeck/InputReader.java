package dev.ossenbeck;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class InputReader {
    private static final Path COMMON_PATH = Paths.get("src", "main", "java", "dev", "ossenbeck");
    private static final Path COMMON_PATH_TEST = Paths.get("src", "test", "java", "dev", "ossenbeck");
    private final Path input;

    private InputReader(Path path, int puzzle) {
        this.input = path.resolve("puzzle%02d".formatted(puzzle), "input.txt");
    }

    public static PuzzleStep builder() {
        return puzzle -> new InputReader(COMMON_PATH, puzzle);
    }

    public static PuzzleStep testBuilder() {
        return puzzle -> new InputReader(COMMON_PATH_TEST, puzzle);
    }

    @FunctionalInterface
    public interface PuzzleStep {
        InputReader puzzle(int puzzle);
    }

    public String asString() {
        try {
            return Files.readString(input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public List<String> asList() {
        try {
            return Files.readAllLines(input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public Stream<String> asStream() {
        try {
            return Files.lines(input, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
