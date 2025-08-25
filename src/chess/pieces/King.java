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

        /*
         *  Below for loops will generate all possible directions for queen movement until boundaries are reached
         *         {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}}
         *         check for {0,0} is added as that represents current position
         */
        for (int directionColumn = -1; directionColumn <= 1; directionColumn++) {
            for (int directionRow = -1; directionRow <= 1; directionRow++) {
                if (directionColumn == 0 && directionRow == 0) continue;
                char newCol = (char) (col + directionColumn);
                int newRow = row + directionRow;
                if (isValidPosition(newCol, newRow)) {
                    moves.add(new Position(newCol, newRow));
                }
            }
        }
        return moves;
    }
}
