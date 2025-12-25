package dev.ossenbeck.puzzle02;

import dev.ossenbeck.InputReader;
import dev.ossenbeck.Solvable;

import static dev.ossenbeck.common.Util.fibonacci;

public class Puzzle implements Solvable<Long, Long, Long> {
    private final String blueprint;

    public Puzzle(InputReader inputReader) {
        this.blueprint = inputReader.asString();
    }

    @Override
    public Long solvePartOne() {
        var maxHeight = 0L;
        var height = 0L;
        for (var movement : blueprint.toCharArray()) {
            height += movement == '^' ? 1 : -1;
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    @Override
    public Long solvePartTwo() {
        var maxHeight = 0L;
        var height = 0L;
        var count = 0;
        var lastMovement = ' ';
        for (var movement : blueprint.toCharArray()) {
            count = movement == lastMovement ? count + 1 : 1;
            lastMovement = movement;
            height += movement == '^' ? count : -count;
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }

    @Override
    public Long solvePartThree() {
        var maxHeight = 0L;
        var height = 0L;
        var length = blueprint.length();
        var i = 0;
        while (i < length) {
            var movement = blueprint.charAt(i);
            var start = i;

            while (i < length && blueprint.charAt(i) == movement) {
                i++;
            }

            var count = i - start;
            height += movement == '^' ? fibonacci(count) : -fibonacci(count);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxHeight;
    }
}