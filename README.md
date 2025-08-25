# Chess Movement Simulator

A simple console-based Java application to simulate movements of Pawn, King, and Queen on a standard 8x8 chessboard.

# Features
- Supports 'Pawn', 'King', and 'Queen' movements.
- Input format: `Piece, Position` (e.g- 'King, D5').
- Outputs all valid moves from the given position.
- Handles edge cases:
  - Pawn at last rank (no moves).
  - King at corners/edges (restricted moves).
  - Queen at edges/corners.
- Includes JUnit 5 tests for correctness.

# Requirements
- Java 11+
- Maven(for dependency management and running tests)
- Editor (Intellij or Eclipse)

# How to Run

1. Clone the Repository
2. Run Main class
3. Sample Input
  King, D5
4. Possible Moves: C4, C5, C6, D4, D6, E4, E5, E6
   
