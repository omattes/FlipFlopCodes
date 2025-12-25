package dev.ossenbeck.puzzle07;

import dev.ossenbeck.InputReader;
import dev.ossenbeck.Solvable;
import dev.ossenbeck.common.Util;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.IntStream;

import static dev.ossenbeck.common.Util.factorialBig;

public class Puzzle implements Solvable<Long, Long, Long> {
    private final List<int[]> gridInfo;

    public Puzzle(InputReader inputReader) {
        this.gridInfo = inputReader.asStream()
                .map(Util::parseNumbersAsArray)
                .toList();
    }

    @Override
    public Long solvePartOne() {
        return gridInfo.stream()
                .mapToLong(this::countShortestPaths)
                .sum();
    }

    @Override
    public Long solvePartTwo() {
        return gridInfo.stream()
                .mapToLong(info -> countShortestPaths(info[0], info[1], info[0]))
                .sum();
    }

    @Override
    public Long solvePartThree() {
        return gridInfo.stream()
                .map(info -> IntStream.range(0, info[0]).map(_ -> info[1]).toArray())
                .mapToLong(this::countShortestPaths)
                .sum();
    }

    public long countShortestPaths(int... lengths) {
        var totalSteps = 0;
        var denominator = BigInteger.ONE;
        for (var length : lengths) {
            var steps = length - 1;
            totalSteps += steps;
            denominator = denominator.multiply(factorialBig(steps));
        }
        return factorialBig(totalSteps).divide(denominator).longValue();
    }
}