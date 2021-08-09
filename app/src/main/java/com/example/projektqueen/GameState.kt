package com.example.projektqueen


class GameState(fen : String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1") {
    var pieces = fenToPieces(fen)
    // returns MutableList with pieces from fen
    private fun fenToPieces(fen : String) : MutableList<Any> {
        var boardFen = getBoardFen(fen)
        var row = 1
        var col = 1
        var pieces: MutableList<Any> = mutableListOf(Piece())
        pieces.clear()
        for (c in boardFen) // iterate through the boardFen and create objects from the Piece classes
            when (c)
            {
                '/' -> { // go to next row when char is '/' set col to 1
                    row += 1
                    col = 1
                }
                'K' -> {
                    var piece = Piece.King(row, col, 'w')
                    pieces.add(piece)
                }
                'k' -> {
                    var piece = Piece.King(row, col, 'b')
                    pieces.add(piece)
                }
                'Q' -> {
                    var piece = Piece.Queen(row, col, 'w')
                    pieces.add(piece)
                }
                'q' -> {
                    var piece = Piece.Queen(row, col, 'b')
                    pieces.add(piece)
                }
                'R' -> {
                    var piece = Piece.Rook(row, col, 'w')
                    pieces.add(piece)
                }
                'r' -> {
                    var piece = Piece.Rook(row, col, 'b')
                    pieces.add(piece)
                }
                'N' -> {
                    var piece = Piece.Knight(row, col, 'w')
                    pieces.add(piece)
                }
                'n' -> {
                    var piece = Piece.Knight(row, col, 'b')
                    pieces.add(piece)
                }
                'B' -> {
                    var piece = Piece.Bishop(row, col, 'w')
                    pieces.add(piece)
                }
                'b' -> {
                    var piece = Piece.Bishop(row, col, 'b')
                    pieces.add(piece)
                }
                'P' -> {
                    var piece = Piece.Pawn(row, col, 'w')
                    pieces.add(piece)
                }
                'p' -> {
                    var piece = Piece.Pawn(row, col, 'b')
                    pieces.add(piece)
                }
            }
        return pieces
    }
    // returns just the Board part from the fen notation
    private fun getBoardFen(fen : String) : String {
        return fen.split(' ')[0]
    }
    // returns the state part from the fen
    private fun getStateFen(fen : String) : String {
        for (c in fen) {
            if (c == ' ') {
                var pos = fen.find(' ')
            }
        }
    }


}


