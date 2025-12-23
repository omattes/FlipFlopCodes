package dev.ossenbeck;

public class PuzzleRunner {
    private final String moduleName;

    public PuzzleRunner() {
        this.moduleName = PuzzleRunner.class.getPackageName();
    }

    public void run(int puzzle) throws Exception {
        var formattedPuzzle = String.format("%02d", puzzle);
        var fullQualifiedClassName = moduleName + ".puzzle" + formattedPuzzle + ".Puzzle";
        var puzzleInstance = Class.forName(fullQualifiedClassName)
                .getDeclaredConstructor(InputReader.class)
                .newInstance(InputReader.builder().puzzle(puzzle));
        if (puzzleInstance instanceof Solvable<?, ?, ?> solvable) {
            System.out.println("Puzzle " + puzzle);
            solvable.printParts();
            System.out.println();
        }
    }
}