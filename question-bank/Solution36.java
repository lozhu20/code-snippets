import java.util.HashSet;
import java.util.Set;

public class Solution36 {
    public static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> colSet = new HashSet<>(9);
            Set<Character> rowSet = new HashSet<>(9);
            for (int col = 0; col < 9; col++) {
                char c = board[col][row];
                if (c != '.') {
                    if (colSet.contains(c)) {
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }

                c = board[row][col];
                if (c != '.') {
                    if (rowSet.contains(c)) {
                        return false;
                    } else {
                        rowSet.add(c);
                    }
                }

                if ((row + 1) % 3 == 0 && (col + 1) % 3 == 0) {
                    Set<Character> areaSet = new HashSet<>(9);
                    for (int i = row - 2; i <= row; i++) {
                        for (int j = col - 2; j <= col; j++) {
                            c = board[i][j];
                            if (c != '.') {
                                if (areaSet.contains(c)) {
                                    return false;
                                } else {
                                    areaSet.add(c);
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '.', '.', '9', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'1', '.', '.', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '.', '2', '.', '6', '.', '.'},
                {'.', '9', '.', '.', '.', '.', '.', '7', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '8', '.', '.', '.', '.', '.'}
        };
        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
