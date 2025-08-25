package chess.service;

import chess.factory.PieceFactory;
import chess.model.Position;
import chess.pieces.Piece;

import java.util.List;
import java.util.stream.Collectors;

public class ChessService {

    /**
     * Creates piece, returns  possible moves
     */
    public List<String> getMoves(String input) {
        String[] parts = input.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Input must be 'Piece, Position'");
        }

        String type = parts[0].trim();
        Position pos = Position.fromString(parts[1].trim());
        Piece piece = PieceFactory.createPiece(type, pos);

        return piece.getPossibleMoves()
                .stream()
                .map(Position::toString)
                .sorted()
                .collect(Collectors.toList());
    }
}
