package dev.ossenbeck;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class SolvableTest<T, U, V> {
    private final Solvable<T, U, V> puzzleInstance;

    protected SolvableTest(Function<InputReader, Solvable<T, U, V>> constructor, int puzzle) {
        this.puzzleInstance = constructor.apply(InputReader.testBuilder().puzzle(puzzle));
    }

    protected abstract T getExpectedResultPartOne();

    protected abstract U getExpectedResultPartTwo();

    protected abstract V getExpectedResultPartThree();

    @Test
    protected void testPartOne() {
        assertThat(puzzleInstance.solvePartOne()).isEqualTo(getExpectedResultPartOne());
    }

    @Test
    protected void testPartTwo() {
        assertThat(puzzleInstance.solvePartTwo()).isEqualTo(getExpectedResultPartTwo());
    }

    @Test
    protected void testPartThree() {
        assertThat(puzzleInstance.solvePartThree()).isEqualTo(getExpectedResultPartThree());
    }
}