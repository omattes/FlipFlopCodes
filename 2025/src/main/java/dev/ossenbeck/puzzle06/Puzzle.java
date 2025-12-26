package dev.ossenbeck.puzzle06;

import dev.ossenbeck.InputReader;
import dev.ossenbeck.Solvable;
import dev.ossenbeck.common.Util;

import java.util.List;
import java.util.stream.LongStream;

import static dev.ossenbeck.common.Util.mod;

public class Puzzle implements Solvable<Long, Long, Long> {
    private final List<Speed> birdSpeeds;
    private final int skySize;
    private final int frameMin;
    private final int frameMax;

    public Puzzle(InputReader inputReader) {
        this(inputReader, 1000, 500);
    }

    public Puzzle(InputReader inputReader, int skySize, int frameSize) {
        this.birdSpeeds = inputReader.asStream()
                .map(Util::parseNumbersAsArray)
                .map(n -> new Speed(n[0], n[1]))
                .toList();
        this.skySize = skySize;
        this.frameMin = (skySize - frameSize) / 2;
        this.frameMax = frameMin + frameSize;
    }

    @Override
    public Long solvePartOne() {
        return takePicturesAndCountBirds(100L, 1);
    }

    @Override
    public Long solvePartTwo() {
        return takePicturesAndCountBirds(3600L, 1000);
    }

    @Override
    public Long solvePartThree() {
        return takePicturesAndCountBirds(31556926L, 1000);
    }

    public Long takePicturesAndCountBirds(long seconds, int captures) {
        return LongStream.rangeClosed(1, captures)
                .map(i -> i * seconds)
                .map(time ->
                        birdSpeeds.stream()
                                .filter(speed -> mod(speed.x() * time, skySize) >= frameMin
                                        && mod(speed.x() * time, skySize) < frameMax
                                        && mod(speed.y() * time, skySize) >= frameMin
                                        && mod(speed.y() * time, skySize) < frameMax
                                ).count()
                ).sum();
    }
}