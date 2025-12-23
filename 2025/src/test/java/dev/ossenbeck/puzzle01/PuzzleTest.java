package dev.ossenbeck.puzzle01;

import dev.ossenbeck.SolvableTest;

class PuzzleTest extends SolvableTest<Long, Long, Long> {
    protected PuzzleTest() {
        super(Puzzle::new, 1);
    }

    @Override
    protected Long getExpectedResultPartOne() {
        return 24L;
    }

    @Override
    protected Long getExpectedResultPartTwo() {
        return 16L;
    }

    @Override
    protected Long getExpectedResultPartThree() {
        return 19L;
    }
}