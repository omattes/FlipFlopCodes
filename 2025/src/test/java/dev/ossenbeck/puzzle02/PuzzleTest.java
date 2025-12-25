package dev.ossenbeck.puzzle02;

import dev.ossenbeck.SolvableTest;

class PuzzleTest extends SolvableTest<Long, Long, Long> {
    protected PuzzleTest() {
        super(Puzzle::new, 2);
    }

    @Override
    protected Long getExpectedResultPartOne() {
        return 6L;
    }

    @Override
    protected Long getExpectedResultPartTwo() {
        return 15L;
    }

    @Override
    protected Long getExpectedResultPartThree() {
        return 4L;
    }
}