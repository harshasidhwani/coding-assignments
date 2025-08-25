package chess.pieces;

import chess.model.Position;


import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Position position) {
        super(position);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> moves = new ArrayList<>();
        char col = position.getColumn();
        int row = position.getRow();

        int[] directions = {-1, 0, 1};

        for (int dc : directions) {
            for (int dr : directions) {
                if (dc == 0 && dr == 0) continue;
                char newCol = col;
                int newRow = row;
                while (true) {
                    newCol += dc;
                    newRow += dr;
                    if (!isValidPosition(newCol, newRow)) break;
                    moves.add(new Position(newCol, newRow));
                }
            }
        }
        return moves;
    }
}
