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

        /*
         * Below for loops will generate all possible directions for queen movement until boundaries are reached
         * All 8 directions, unlimited steps
         * {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}}
         *  check for {0,0} is added as that represents current position
         */
        for (int directionColumn : directions) {
            for (int directionRow : directions) {
                if (directionColumn == 0 && directionRow == 0) continue;
                char newCol = col;
                int newRow = row;
                while (true) {
                    newCol += directionColumn;
                    newRow += directionRow;
                    if (!isValidPosition(newCol, newRow)) break;
                    moves.add(new Position(newCol, newRow));
                }
            }
        }
        return moves;
    }
}
