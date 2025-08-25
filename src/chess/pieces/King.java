package chess.pieces;

import chess.model.Position;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Position position) {
        super(position);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> moves = new ArrayList<>();
        char col = position.getColumn();
        int row = position.getRow();

        for (int dc = -1; dc <= 1; dc++) {
            for (int dr = -1; dr <= 1; dr++) {
                if (dc == 0 && dr == 0) continue;
                char newCol = (char) (col + dc);
                int newRow = row + dr;
                if (isValidPosition(newCol, newRow)) {
                    moves.add(new Position(newCol, newRow));
                }
            }
        }
        return moves;
    }
}
