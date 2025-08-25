package chess.pieces;

import chess.model.Position;
import java.util.List;

public abstract class Piece {
    protected Position position;

    public Piece(Position position) {
        this.position = position;
    }

    public abstract List<Position> getPossibleMoves();

    protected boolean isValidPosition(char column, int row) {
        return Position.isValid(column, row);
    }
}
