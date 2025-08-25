package chess.model;

public class Position {

    // Position class has column and row which together represent square on board
    private char column; // A-H
    private int row;     // 1-8

    public Position(char column, int row) {
        if (!isValid(column, row)) {
            throw new IllegalArgumentException("Invalid board position: " + column + row);
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    /*
     *  Method to verify every move of king,queen, pawn is within the boundary of chess board
     *  Validates positions (A1 to H8).
     */

    public static boolean isValid(char column, int row) {
        return (column >= 'A' && column <= 'H') && (row >= 1 && row <= 8);
    }

    public static Position fromString(String cell) {
        if (cell == null || cell.length() < 2) {
            throw new IllegalArgumentException("Invalid cell format: " + cell);
        }
        char col = Character.toUpperCase(cell.charAt(0));
        int row = Integer.parseInt(cell.substring(1));
        return new Position(col, row);
    }

    @Override
    public String toString() {
        return column + String.valueOf(row);
    }
}
