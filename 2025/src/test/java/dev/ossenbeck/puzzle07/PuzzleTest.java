package dev.ossenbeck.puzzle07;

import dev.ossenbeck.SolvableTest;

class PuzzleTest extends SolvableTest<Long, Long, Long> {
    protected PuzzleTest() {
        super(Puzzle::new, 7);
    }

    @Override
    protected Long getExpectedResultPartOne() {
        return 11L;
    }

    @Override
    protected Long getExpectedResultPartTwo() {
        return 108L;
    }

    @Override
    protected Long getExpectedResultPartThree() {
        return 98L;
    }
}