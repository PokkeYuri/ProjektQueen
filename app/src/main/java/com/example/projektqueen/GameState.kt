package com.example.projektqueen

import android.util.Log



class GameState(fen : String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1") {
    private val where = "GameState"
    init {
        Log.i(where, "created GameState with fen: $fen")
    }
    // Board FEN (only the board part from the notation)            : rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR
    private var boardFen = getBoardFen(fen)
    // State FEN (only the rights / state part from the notation)   : w KQkq - 0 1
    private var stateFen = getStateFen(fen)
    // MutableList of all pieces on the board (to keep track and draw them every piece have a location an color)
    private var pieces = fenToPieces(fen)
    /*
    // Mutable list of all rights:
    [0] -> moveRight; ("w" or "b" for white or black)
    [1] -> castleRights; ("KQkq" : Both kings can castle both sides -> "-" : No one can castle - K: white king -> king side, Q: white king -> queen side (lowercase letters are blacks rights))
    [2] -> enPassant; (- when no square or square notation (a1 - h8))
    [3] -> halfMove; (increase when a player moved, starting at 0)
    [4] -> fullMove; (increase when a black moved, starting at 1)
    */
    private var rights : MutableList<String> = getRights()


    // getter method for pieces
    fun getPieces() : MutableList<Piece> {
        return pieces
    }
    fun getRights(): MutableList<String> {
        val splits = stateFen.split(' ')
        val moveRight = splits[0]
        val castleRights = splits[1]
        val enPassant = splits[2]
        val halfMove = splits[3]
        val fullMove = splits[4]
        return mutableListOf(moveRight, castleRights, enPassant, halfMove, fullMove)
    }
    // returns MutableList with pieces from fen
    private fun fenToPieces(fen : String) : MutableList<Piece> {
        val boardFen = getBoardFen(fen)
        var row = 1
        var col = 1
        val pieces: MutableList<Piece> = mutableListOf(Piece('a', 1, 1, 'b'))
        pieces.clear()
        for (c in boardFen) // iterate through the boardFen and create objects from the Piece classes
            when (c)
            {
                '/' -> { // go to next row when char is '/' set col to 1
                    row += 1
                    col = 1
                }
                'K' -> {
                    val piece = Piece('k', row, col, 'w')
                    col++
                    pieces.add(piece)
                }
                'k' -> {
                    val piece = Piece('k', row, col, 'b')
                    col++
                    pieces.add(piece)
                }
                'Q' -> {
                    val piece = Piece('q', row, col, 'w')
                    col++
                    pieces.add(piece)
                }
                'q' -> {
                    val piece = Piece('q', row, col, 'b')
                    col++
                    pieces.add(piece)
                }
                'R' -> {
                    val piece = Piece('r', row, col, 'w')
                    col++
                    pieces.add(piece)
                }
                'r' -> {
                    val piece = Piece('r', row, col, 'b')
                    col++
                    pieces.add(piece)
                }
                'N' -> {
                    val piece = Piece('n', row, col, 'w')
                    col++
                    pieces.add(piece)
                }
                'n' -> {
                    val piece = Piece('n', row, col, 'b')
                    col++
                    pieces.add(piece)
                }
                'B' -> {
                    val piece = Piece('b', row, col, 'w')
                    col++
                    pieces.add(piece)
                }
                'b' -> {
                    val piece = Piece('b', row, col, 'b')
                    col++
                    pieces.add(piece)
                }
                'P' -> {
                    val piece = Piece('p', row, col, 'w')
                    col++
                    pieces.add(piece)
                }
                'p' -> {
                    val piece = Piece('p', row, col, 'b')
                    col++
                    pieces.add(piece)
                }
                '1' -> {
                    col ++
                }
                '2' -> {
                    col += 2
                }
                '3' -> {
                    col += 3
                }
                '4' -> {
                    col += 4
                }
                '5' -> {
                    col += 5
                }
                '6' -> {
                    col += 6
                }
                '7' -> {
                    col += 7
                }
                '8' -> {
                    col += 8
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


