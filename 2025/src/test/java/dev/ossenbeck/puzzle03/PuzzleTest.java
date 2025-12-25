package dev.ossenbeck.puzzle03;

import dev.ossenbeck.SolvableTest;

class PuzzleTest extends SolvableTest<String, Long, Long> {
    protected PuzzleTest() {
        super(Puzzle::new, 3);
    }

    @Override
    protected String getExpectedResultPartOne() {
        return "10,20,30";
    }

    @Override
    protected Long getExpectedResultPartTwo() {
        return 0L;
    }

    @Override
    protected Long getExpectedResultPartThree() {
        return 37L;
    }
}