package com.example.projektqueen

import android.graphics.Color
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.board.*


const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    // the currently selected square (null when no selection)
    var selectedSquare : ImageView? = null
    var lastSelectedSquare : ImageView? = null
    var lastSelectedBg = 'w'

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(TAG, "Starting Main Activity")

        btnTest.setOnClickListener {
            val gs = GameState()
            drawBoard(gs)
            setClickEvents()
        }
    }
    //
    private fun drawBoard(gs : GameState) {
        setContentView(R.layout.board)
        val squares = getSquares()
        // clear board
        for (square in squares) {
            square.setImageResource(R.drawable.`__`)
        }
        val pieces = gs.getPieces()
        for (piece in pieces) {
            val squareName = posToSquareName(piece.row, piece.col)
            val square = getViewBySquareName(squareName)
            Log.i(TAG, "Piece: ${piece.color}${piece.type} Pos: ${piece.row}${piece.col}")
            when ("${piece.color}${piece.type}") {
                "br" -> square.setImageResource(R.drawable.br)
                "wr" -> square.setImageResource(R.drawable.wr)
                "bq" -> square.setImageResource(R.drawable.bq)
                "wq" -> square.setImageResource(R.drawable.wq)
                "bk" -> square.setImageResource(R.drawable.bk)
                "wk" -> square.setImageResource(R.drawable.wk)
                "bb" -> square.setImageResource(R.drawable.bb)
                "wb" -> square.setImageResource(R.drawable.wb)
                "bn" -> square.setImageResource(R.drawable.bn)
                "wn" -> square.setImageResource(R.drawable.wn)
                "bp" -> square.setImageResource(R.drawable.bp)
                "wp" -> square.setImageResource(R.drawable.wp)
            }
        }
    }

    private fun posToSquareName(row : Int, col : Int) : String {
        var aToH = 'a'
        var oneToEight = '1'
        when (col){
            1 -> {aToH = 'a'}
            2 -> {aToH = 'b'}
            3 -> {aToH = 'c'}
            4 -> {aToH = 'd'}
            5 -> {aToH = 'e'}
            6 -> {aToH = 'f'}
            7 -> {aToH = 'g'}
            8 -> {aToH = 'h'}
        }
        when (row) {
            1 -> {oneToEight = '8'}
            2 -> {oneToEight = '7'}
            3 -> {oneToEight = '6'}
            4 -> {oneToEight = '5'}
            5 -> {oneToEight = '4'}
            6 -> {oneToEight = '3'}
            7 -> {oneToEight = '2'}
            8 -> {oneToEight = '1'}
        }
        return "$aToH$oneToEight"
    }

    private fun setClickEvents() {
        val squares = getSquares()
        for (square in squares) {
            square.setOnClickListener {
                onSquareClick(square)
            }
        }

    }
    private fun getViewBySquareName(sqName : String) : ImageView {
        var view = a1
        when (sqName) {
            "a1" -> {view = a1}
            "b1" -> {view = b1}
            "c1" -> {view = c1}
            "d1" -> {view = d1}
            "e1" -> {view = e1}
            "f1" -> {view = f1}
            "g1" -> {view = g1}
            "h1" -> {view = h1}
            "a2" -> {view = a2}
            "b2" -> {view = b2}
            "c2" -> {view = c2}
            "d2" -> {view = d2}
            "e2" -> {view = e2}
            "f2" -> {view = f2}
            "g2" -> {view = g2}
            "h2" -> {view = h2}
            "a3" -> {view = a3}
            "b3" -> {view = b3}
            "c3" -> {view = c3}
            "d3" -> {view = d3}
            "e3" -> {view = e3}
            "f3" -> {view = f3}
            "g3" -> {view = g3}
            "h3" -> {view = h3}
            "a4" -> {view = a4}
            "b4" -> {view = b4}
            "c4" -> {view = c4}
            "d4" -> {view = d4}
            "e4" -> {view = e4}
            "f4" -> {view = f4}
            "g4" -> {view = g4}
            "h4" -> {view = h4}
            "a5" -> {view = a5}
            "b5" -> {view = b5}
            "c5" -> {view = c5}
            "d5" -> {view = d5}
            "e5" -> {view = e5}
            "f5" -> {view = f5}
            "g5" -> {view = g5}
            "h5" -> {view = h5}
            "a6" -> {view = a6}
            "b6" -> {view = b6}
            "c6" -> {view = c6}
            "d6" -> {view = d6}
            "e6" -> {view = e6}
            "f6" -> {view = f6}
            "g6" -> {view = g6}
            "h6" -> {view = h6}
            "a7" -> {view = a7}
            "b7" -> {view = b7}
            "c7" -> {view = c7}
            "d7" -> {view = d7}
            "e7" -> {view = e7}
            "f7" -> {view = f7}
            "g7" -> {view = g7}
            "h7" -> {view = h7}
            "a8" -> {view = a8}
            "b8" -> {view = b8}
            "c8" -> {view = c8}
            "d8" -> {view = d8}
            "e8" -> {view = e8}
            "f8" -> {view = f8}
            "g8" -> {view = g8}
            "h8" -> {view = h8}
        }
        return view
    }
    // returns all squares in a mutable list of ImageViews
    private fun getSquares() : MutableList<ImageView> {
        return mutableListOf(a1, a2, a3, a4, a5, a6, a7, a8, b1, b2, b3, b4, b5, b6, b7, b8, c1, c2, c3, c4, c5, c6, c7, c8, d1, d2, d3, d4, d5, d6, d7, d8, e1, e2, e3, e4, e5, e6, e7, e8, f1, f2, f3, f4, f5, f6, f7, f8, g1, g2, g3, g4, g5, g6, g7, g8, h1, h2, h3, h4, h5, h6, h7, h8)
    }
    // on click for every square
    private fun onSquareClick(square : ImageView) {
        lastSelectedSquare = selectedSquare
        selectedSquare = square
        if (lastSelectedSquare != null) {
            lastSelectedSquare!!.clearColorFilter()
        }

        square.setColorFilter(Color.BLUE)
        Log.i(TAG, square.toString())
    }


}