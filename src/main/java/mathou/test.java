package mathou;

import java.util.ArrayList;
import java.util.List;

public class test {
    enum WinningPattern {
        PATTERN1(new String[] {"10001", "01110", "00000"}),
        PATTERN2(new String[] {"10001", "01010", "00100"}),
        PATTERN3(new String[] {"111111", "000000", "000000"}),
        PATTERN4(new String[] {"00011", "00100", "11000"});

        private String[] pattern;

        WinningPattern(String[] pattern) {
            this.pattern = pattern;
        }

        public String[] getPattern() {
            return pattern;
        }
    }

    public static List<String> checkWinningPatterns(String[][] grid) {
        List<String> results = new ArrayList<>();
        for (WinningPattern wp : WinningPattern.values()) {
            String result = isWinningPattern(grid, wp.getPattern());
            if (result != null) {
                results.add("Match found for pattern: " + wp.name() + ", " + result);
            }
        }
        return results;
    }

    private static String isWinningPattern(String[][] grid, String[] pattern) {
        if (grid.length < pattern.length) return null;  // Ensure the grid has enough rows

        int matchCount = 0;
        for (int row = 0; row < pattern.length; row++) {
            if (grid[row].length < 3) return null;  // Each row in the grid must have at least three elements
            if (pattern[row].length() < 3)
                return null;  // Each pattern row must specify at least the first three elements

            String expectedSymbol = grid[row][0];  // The first symbol of the row in the grid
            matchCount = 0;
            for (int col = 0; col < pattern[row].length(); col++) {
                if (pattern[row].charAt(col) == '1') {
                    if (col < grid[row].length && grid[row][col].equals(String.valueOf(expectedSymbol))) {
                        matchCount++;
                    } else {
                        return null;  // Break early if any required match fails
                    }
                }
            }
            if (matchCount < 3) return null;  // Ensure at least three matches
        }
        return "Number of symbols matched: " + matchCount + ", Symbol: " + grid[0][0];  // Return the number of matched symbols and their type
    }


    public static void main(String[] args) {
        String[][] grid = {
                {"A", "A", "A", "Z", "Z"},
                {"B", "A", "Z", "A", "A"},
                {"Z", "Z", "B", "B", "B"}
        };

        List<String> winningPatterns = checkWinningPatterns(grid);
        if (!winningPatterns.isEmpty()) {
            winningPatterns.forEach(System.out::println);
        } else {
            System.out.println("No winning patterns found.");
        }
    }
}
