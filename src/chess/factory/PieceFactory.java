package chess.factory;

import chess.model.Position;
import chess.pieces.*;

public class PieceFactory {

    public static Piece createPiece(String type, Position position) {
        switch (type.toUpperCase()) {
            case "PAWN": return new Pawn(position);
            case "KING": return new King(position);
            case "QUEEN": return new Queen(position);
            default: throw new IllegalArgumentException("Unknown piece type: " + type);
        }
    }
}
