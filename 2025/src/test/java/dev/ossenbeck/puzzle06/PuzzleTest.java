package dev.ossenbeck.puzzle06;

import dev.ossenbeck.SolvableTest;

class PuzzleTest extends SolvableTest<Long, Long, Long> {
    private final static int SKY_SIZE = 8;
    private final static int FRAME_SIZE = 4;

    protected PuzzleTest() {
        super((ir) -> new Puzzle(ir, SKY_SIZE, FRAME_SIZE), 6);
    }

    @Override
    protected Long getExpectedResultPartOne() {
        return 4L;
    }

    @Override
    protected Long getExpectedResultPartTwo() {
        return 0L;
    }

    @Override
    protected Long getExpectedResultPartThree() {
        return 1500L;
    }
}