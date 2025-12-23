package dev.ossenbeck;

import java.util.function.Supplier;

public interface Solvable<T, U, V> {
    T solvePartOne();

    U solvePartTwo();

    V solvePartThree();

    default void printParts() {
        print(this::solvePartOne, 1);
        print(this::solvePartTwo, 2);
        print(this::solvePartThree, 3);
    }

    private void print(Supplier<?> partFunction, int part) {
        var start = System.currentTimeMillis();
        var result = partFunction.get();
        var end = System.currentTimeMillis();
        System.out.printf("Part %s: %s in %sms%n", part, result, end - start);
    }
}
