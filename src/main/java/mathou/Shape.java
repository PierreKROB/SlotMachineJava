package mathou;

import java.util.Arrays;

public enum Shape {
    SHAPE1(
            "XXXXX",
            "     ",
            "     "),
    SHAPE2(
            "     ",
            "XXXXX",
            "     "),
    SHAPE3(
            "     ",
            "     ",
            "XXXXX"),
    SHAPE4(
            "X   X",
            " X X ",
            "  X  "),
    SHAPE5(
            "  X  ",
            " X X ",
            "X   X"),
    SHAPE6(
            " XXX ",
            "X   X",
            "     "),
    SHAPE7(
            "     ",
            " XXX ",
            "X   X"),
    SHAPE8(
            "     ",
            "X   X",
            " XXX "),
    SHAPE9(
            "X   X",
            " XXX ",
            "     "),
    SHAPE10(
            "   XX",
            "  X  ",
            "XX   "),
    SHAPE11(
            "XX   ",
            "  X  ",
            "   XX"),
    SHAPE12(
            "   X ",
            "X X X",
            " X   "),
    SHAPE13(
            " X   ",
            "X X X",
            "   X "),
    SHAPE14(
            "X X X",
            " X X ",
            "     "),
    SHAPE15(
            "     ",
            " X X ",
            "X X X"),
    SHAPE16(
            "  X  ",
            "XX XX",
            "     "),
    SHAPE17(
            "     ",
            "XX XX",
            "  X  "),
    SHAPE18(
            "  X  ",
            "     ",
            "XX XX"),
    SHAPE19(
            "XX XX",
            "     ",
            "  X  "),
    SHAPE20(
            " XXX ",
            "     ",
            "X   X"),
    SHAPE21(
            "X   X",
            "     ",
            " XXX "),
    SHAPE22(
            "  X  ",
            "X   X",
            " X X "),
    SHAPE23(
            " X X ",
            "X   X",
            "  X  "),
    SHAPE24(
            "X X X",
            "     ",
            " X X "),
    SHAPE25(
            " X X ",
            "     ",
            "X X X");


    private final String[] pattern;

    Shape(String... pattern) {
        this.pattern = Arrays.copyOf(pattern, 3);
        System.out.println("Shape created: " + this.name() + " with pattern: " + Arrays.toString(this.pattern));
    }

    public float getMultiplier(Symbole[][] board) {
        int matchesNumber = 0;
        Symbole previousSymbol = board[0][0];  // Assuming there's at least one row and one column.

        System.out.println("Evaluating multiplier for shape: " + this.name());

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[i].length(); j++) {
                System.out.println("Inspecting cell [" + i + "][" + j + "]: " + pattern[i].charAt(j));

                if (pattern[i].charAt(j) != ' ') {
                    System.out.println("Match found at [" + i + "][" + j + "]");
                    if (previousSymbol.getNom().equals("wild")) {
                        matchesNumber++;
                        System.out.println("Wild match. Total matches: " + matchesNumber);
                        previousSymbol = board[i][j];
                    } else if (previousSymbol.equals(board[i][j]) || board[i][j].getNom().equals("wild")) {
                        matchesNumber++;
                        System.out.println("Symbol match. Total matches: " + matchesNumber);
                    } else {
                        System.out.println("Mismatch found. Returning multiplier for " + previousSymbol.getNom());
                        return (float) previousSymbol.getMultiplier(matchesNumber);
                    }
                }
            }
        }

        System.out.println("All cells inspected. Returning multiplier for " + previousSymbol.getNom());
        return (float) previousSymbol.getMultiplier(matchesNumber);
    }
}