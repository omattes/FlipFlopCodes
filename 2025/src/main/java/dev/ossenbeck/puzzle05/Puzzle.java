package dev.ossenbeck.puzzle05;

import dev.ossenbeck.InputReader;
import dev.ossenbeck.Solvable;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static dev.ossenbeck.common.Util.mod;

public class Puzzle implements Solvable<Long, String, Long> {
    private final char[] tunnels;

    public Puzzle(InputReader inputReader) {
        this.tunnels = inputReader.asString().toCharArray();
    }

    @Override
    public Long solvePartOne() {
        var result = new AtomicLong(0);
        traverseTunnels((tunnel, i) -> result.addAndGet(Math.abs(i - tunnel)));
        return result.get();
    }

    @Override
    public String solvePartTwo() {
        var visited = new BitSet(tunnels.length);
        traverseTunnels((tunnel, i) -> {
            visited.set(tunnel);
            visited.set(i);
        });
        return IntStream.range(0, tunnels.length)
                .filter(i -> !visited.get(i))
                .mapToObj(i -> tunnels[i])
                .distinct()
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    @Override
    public Long solvePartThree() {
        var result = new AtomicLong(0);
        traverseTunnels((tunnel, i) ->
                result.addAndGet(Character.isUpperCase(tunnels[tunnel]) ? -Math.abs(i - tunnel) : Math.abs(i - tunnel))
        );
        return result.get();
    }

    private void traverseTunnels(BiConsumer<Integer, Integer> onMatch) {
        var tunnel = 0;
        var i = 1;
        while (true) {
            if (tunnels[tunnel] == tunnels[i]) {
                onMatch.accept(tunnel, i);
                tunnel = ++i;
                if (tunnel == tunnels.length) {
                    break;
                }
            }
            i = mod(i + 1, tunnels.length);
        }
    }

}