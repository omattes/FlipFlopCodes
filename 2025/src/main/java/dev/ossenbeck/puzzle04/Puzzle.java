package dev.ossenbeck.puzzle04;

import dev.ossenbeck.InputReader;
import dev.ossenbeck.Solvable;
import dev.ossenbeck.common.Coordinate;
import dev.ossenbeck.common.Util;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToLongBiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Puzzle implements Solvable<Long, Long, Long> {
    private final List<Coordinate> trashCoordinates;

    public Puzzle(InputReader inputReader) {
        this.trashCoordinates = inputReader.asStream()
                .map(Util::parseNumbersAsArray)
                .map(n -> new Coordinate(n[0], n[1]))
                .collect(Collectors.toList());
        this.trashCoordinates.addFirst(new Coordinate(0, 0));
    }

    @Override
    public Long solvePartOne() {
        return calculateTotalSteps(trashCoordinates, Coordinate::manhattanDistance);
    }

    @Override
    public Long solvePartTwo() {
        return calculateTotalSteps(trashCoordinates, Coordinate::chebyshevDistance);
    }

    @Override
    public Long solvePartThree() {
        var optimizedOrder = trashCoordinates.stream()
                .sorted(Comparator.comparingLong(trashCoordinates.getFirst()::manhattanDistance))
                .toList();
        return calculateTotalSteps(optimizedOrder, Coordinate::chebyshevDistance);
    }

    private long calculateTotalSteps(List<Coordinate> trash, ToLongBiFunction<Coordinate, Coordinate> distanceMeasurement) {
        return IntStream.range(1, trash.size())
                .mapToLong(i -> distanceMeasurement.applyAsLong(trash.get(i - 1), trash.get(i)))
                .sum();
    }
}