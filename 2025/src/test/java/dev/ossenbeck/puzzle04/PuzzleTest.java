package dev.ossenbeck.puzzle04;

import dev.ossenbeck.SolvableTest;

class PuzzleTest extends SolvableTest<Long, Long, Long> {
    protected PuzzleTest() {
        super(Puzzle::new, 4);
    }

    @Override
    protected Long getExpectedResultPartOne() {
        return 24L;
    }

    @Override
    protected Long getExpectedResultPartTwo() {
        return 12L;
    }

    @Override
    protected Long getExpectedResultPartThree() {
        return 9L;
    }
}