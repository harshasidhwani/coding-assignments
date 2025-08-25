package chess.pieces;

import chess.model.Position;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Position position) {
        super(position);
    }

    @Override
    public List<Position> getPossibleMoves() {
        List<Position> moves = new ArrayList<>();
        /**
         *  Calculating pawn position in vertical forward direction
         *  +1 row (if valid)
         */
        int newRow = position.getRow() + 1;
        if (isValidPosition(position.getColumn(), newRow)) {
            moves.add(new Position(position.getColumn(), newRow));
        }
        return moves;
    }
}
