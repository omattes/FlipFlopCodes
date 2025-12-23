package dev.ossenbeck;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class BenchmarkState {
    private final String moduleName;
    @Param("1")
    public int puzzle;

    Solvable<?, ?, ?> solvable;

    public BenchmarkState() {
        this.moduleName = BenchmarkState.class.getPackageName();
    }

    @Setup
    public void createPuzzle() throws Exception {
        var formattedPuzzle = String.format("%02d", puzzle);
        var fullQualifiedClassName = moduleName + ".puzzle" + formattedPuzzle + ".Puzzle";
        var puzzleInstance = Class.forName(fullQualifiedClassName)
                .getDeclaredConstructor(InputReader.class)
                .newInstance(InputReader.builder().puzzle(puzzle));
        if (puzzleInstance instanceof Solvable<?, ?, ?> s) {
            this.solvable = s;
        }
    }
}