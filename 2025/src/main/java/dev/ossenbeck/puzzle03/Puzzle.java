package dev.ossenbeck.puzzle03;

import dev.ossenbeck.InputReader;
import dev.ossenbeck.Solvable;

import java.util.Map;
import java.util.stream.Collectors;

public class Puzzle implements Solvable<String, Long, Long> {
    private final Map<String, Long> colorCount;

    public Puzzle(InputReader inputReader) {
        colorCount = inputReader.asStream().collect(Collectors.groupingBy(rgb -> rgb, Collectors.counting()));
    }

    @Override
    public String solvePartOne() {
        return colorCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No colors found");
    }

    @Override
    public Long solvePartTwo() {
        return colorCount.keySet().stream()
                .filter(rgb -> BushLabel.fromRgb(rgb) == BushLabel.GREEN)
                .mapToLong(colorCount::get)
                .sum();
    }

    @Override
    public Long solvePartThree() {
        return colorCount.entrySet().stream()
                .mapToLong(entry -> BushLabel.fromRgb(entry.getKey()).pointers() * entry.getValue())
                .sum();
    }
}