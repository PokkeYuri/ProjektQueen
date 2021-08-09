package com.example.projektqueen

import android.util.Log



class GameState(fen : String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1") {
    private val where = "GameState"
    init {
        Log.i(where, "created GameState with fen: $fen")
    }
    private var boardFen = getBoardFen(fen)
    private var stateFen = getStateFen(fen)
    private var pieces = fenToPieces(fen)

    // getter method for pieces
    fun getPieces() : MutableList<Any> {
        return pieces
    }
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
                    val piece = Piece.King(row, col, 'w')
                    pieces.add(piece)
                }
                'k' -> {
                    val piece = Piece.King(row, col, 'b')
                    pieces.add(piece)
                }
                'Q' -> {
                    val piece = Piece.Queen(row, col, 'w')
                    pieces.add(piece)
                }
                'q' -> {
                    val piece = Piece.Queen(row, col, 'b')
                    pieces.add(piece)
                }
                'R' -> {
                    val piece = Piece.Rook(row, col, 'w')
                    pieces.add(piece)
                }
                'r' -> {
                    val piece = Piece.Rook(row, col, 'b')
                    pieces.add(piece)
                }
                'N' -> {
                    val piece = Piece.Knight(row, col, 'w')
                    pieces.add(piece)
                }
                'n' -> {
                    val piece = Piece.Knight(row, col, 'b')
                    pieces.add(piece)
                }
                'B' -> {
                    val piece = Piece.Bishop(row, col, 'w')
                    pieces.add(piece)
                }
                'b' -> {
                    val piece = Piece.Bishop(row, col, 'b')
                    pieces.add(piece)
                }
                'P' -> {
                    val piece = Piece.Pawn(row, col, 'w')
                    pieces.add(piece)
                }
                'p' -> {
                    val piece = Piece.Pawn(row, col, 'b')
                    pieces.add(piece)
                }
            }
        return pieces
    }
    /*
        next two functions will cut the fen in two pieces:
        the "boardFen" -> "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR"
        and the "stateFen" -> "w KQkq - 0 1"
    */
    // returns just the Board part from the fen notation ("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR")
    private fun getBoardFen(fen : String) : String {
        return fen.split(' ')[0]
    }
    // returns the state part from the fen ("w KQkq - 0 1")
    private fun getStateFen(fen : String) : String {
        return fen.split(' ', limit = 2)[1]
    }


}


