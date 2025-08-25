package chess;

import chess.service.ChessService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChessServiceTest {

    private final ChessService service = new ChessService();

    @Test
    void testKingMoves() {
        List<String> moves = service.getMoves("King, D5");
        assertTrue(moves.containsAll(List.of("C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6")));
        assertEquals(8, moves.size());
    }

    @Test
    void testPawnMoves() {
        List<String> moves = service.getMoves("Pawn, G1");
        assertEquals(List.of("G2"), moves);
    }

    @Test
    void testQueenMoves() {
        List<String> moves = service.getMoves("Queen, E4");
        assertTrue(moves.contains("A4"));
        assertTrue(moves.contains("H7"));
        assertTrue(moves.contains("H1"));
        assertTrue(moves.contains("E8"));
    }

    @Test
    void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> service.getMoves("Dragon, Z9"));
    }

    // Edge cases
    @Test
    void testPawnAtLastRankHasNoMoves() {
        List<String> moves = service.getMoves("Pawn, D8");
        assertTrue(moves.isEmpty(), "Pawn at last rank should have no moves");
    }

    @Test
    void testKingAtCorner() {
        List<String> moves = service.getMoves("King, A1");
        assertTrue(moves.containsAll(List.of("A2", "B1", "B2")));
        assertEquals(3, moves.size());
    }

    @Test
    void testKingAtEdge() {
        List<String> moves = service.getMoves("King, H5");
        assertTrue(moves.containsAll(List.of("G4", "G5", "G6", "H4", "H6")));
        assertEquals(5, moves.size());
    }

    @Test
    void testQueenAtCorner() {
        List<String> moves = service.getMoves("Queen, H8");
        // Should cover row, column, and diagonals
        assertTrue(moves.contains("A8"));  // left along row
        assertTrue(moves.contains("H1"));  // down column
        assertTrue(moves.contains("A1"));  // diagonal
    }

}
