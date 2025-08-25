package chess;

import chess.service.ChessService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChessService service = new ChessService();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter input in the form of (Piece, Position) eg: King, D5 :");
        String input = sc.nextLine();

        try {
            List<String> moves = service.getMoves(input);
            if(moves.isEmpty())
            {
                System.out.println("Moves not possible for given input");
            }
            System.out.println("Possible Moves: " + String.join(", ", moves));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
