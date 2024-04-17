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
    }

    public float getMultiplier(Symbole[][] board) {
        int matchesNumber = 0;
        Symbole previousSymbol = board[0][0];

        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern[0].length(); j++) {
                if ( pattern[i].charAt(j) != ' ') {
                    if (previousSymbol.getNom().equals("wild") ) {
                        matchesNumber++;
                        previousSymbol = board[i][j];
                    } else if (previousSymbol.equals(board[i][j]) || board[i][j].getNom().equals("wild") ) {
                        matchesNumber++;
                    } else {
                        return (float) previousSymbol.getMultiplier(matchesNumber);
                    }
                }
            }
        }

        return (float) previousSymbol.getMultiplier(matchesNumber);

    }
}