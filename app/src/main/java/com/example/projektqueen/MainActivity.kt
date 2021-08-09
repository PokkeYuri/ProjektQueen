package com.example.projektqueen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gs = GameState()
        Log.i(TAG, "Strtup")

        val btnTest = findViewById<Button>(R.id.btnTest)
        btnTest.setOnClickListener {
            Log.i(TAG,"click")
            Log.i(TAG, gs.getPieces().toString())
        }
    }


}