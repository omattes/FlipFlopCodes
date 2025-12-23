package dev.ossenbeck.puzzle01;

import dev.ossenbeck.InputReader;
import dev.ossenbeck.Solvable;

import java.util.List;
import java.util.regex.Pattern;

public class Puzzle implements Solvable<Long, Long, Long> {
    private static final Pattern BANANA_PATTERN = Pattern.compile("na|ne|ba");
    private final List<String> bunch;

    public Puzzle(InputReader inputReader) {
        this.bunch = inputReader.asList();
    }

    @Override
    public Long solvePartOne() {
        return bunch.stream()
                .mapToLong(this::measureBananaScore)
                .sum();
    }

    @Override
    public Long solvePartTwo() {
        return bunch.stream()
                .mapToLong(this::measureBananaScore)
                .filter(score -> score % 2 == 0)
                .sum();
    }

    @Override
    public Long solvePartThree() {
        return bunch.stream()
                .filter(banana -> !banana.contains("ne"))
                .mapToLong(this::measureBananaScore)
                .sum();
    }
    
    private long measureBananaScore(String banana) {
        return BANANA_PATTERN.matcher(banana).results().count();
    }
}