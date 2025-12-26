package dev.ossenbeck.puzzle05;

import dev.ossenbeck.SolvableTest;

class PuzzleTest extends SolvableTest<Long, String, Long> {
    protected PuzzleTest() {
        super(Puzzle::new, 5);
    }

    @Override
    protected Long getExpectedResultPartOne() {
        return 38L;
    }

    @Override
    protected String getExpectedResultPartTwo() {
        return "Bc";
    }

    @Override
    protected Long getExpectedResultPartThree() {
        return -6L;
    }
}