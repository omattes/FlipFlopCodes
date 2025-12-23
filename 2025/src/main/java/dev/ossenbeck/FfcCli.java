package dev.ossenbeck;


import dev.ossenbeck.common.Util;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import picocli.CommandLine;

import java.util.concurrent.Callable;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Option;


@Command(name = "ffcrun",
        mixinStandardHelpOptions = true,
        version = "ffcrun 1.0.0",
        description = "Runs FlipFlop Codes parts for specified puzzle.")
public class FfcCli implements Callable<Integer> {
    @Option(
            names = {"-p", "--puzzles"},
            description = "Space-separated list of puzzles to run (e.g. 1 5 20).",
            defaultValue = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20"
    )
    private String days;

    @Option(
            names = {"-b", "--benchmark"},
            description = "Enables benchmark mode to measure runtime."
    )
    private boolean benchmark;

    @Option(
            names = {"-e", "--error"},
            description = "Prints exceptions."
    )
    private boolean showError;
    private final PuzzleRunner puzzleRunner = new PuzzleRunner();

    @Override
    public Integer call() {
        for (var day : Util.parseNumbers(days)) {
            try {
                puzzleRunner.run(day);
                if (benchmark) {
                    runBenchmarks(day);
                }
            } catch (Exception e) {
                if (showError) {
                    System.out.println("There was an error loading the puzzle for day " + day);
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }

    private void runBenchmarks(int day) throws RunnerException {
        System.out.println("Running benchmark for Puzzle " + day);
        var options = new OptionsBuilder()
                .include(BenchmarkRunner.class.getSimpleName())
                .param("puzzle", String.valueOf(day))
                .forks(1)
                .build();

        new Runner(options).run();
    }

    public static void main(String... args) {
        var exitCode = new CommandLine(new FfcCli()).execute(args);
        System.exit(exitCode);
    }
}