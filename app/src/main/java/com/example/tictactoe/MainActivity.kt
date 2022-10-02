package com.example.tictactoe

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b11 = findViewById<ImageButton>(R.id.button_1_1)
        val b12 = findViewById<ImageButton>(R.id.button_1_2)
        val b13 = findViewById<ImageButton>(R.id.button_1_3)
        val b21 = findViewById<ImageButton>(R.id.button_2_1)
        val b22 = findViewById<ImageButton>(R.id.button_2_2)
        val b23 = findViewById<ImageButton>(R.id.button_2_3)
        val b31 = findViewById<ImageButton>(R.id.button_3_1)
        val b32 = findViewById<ImageButton>(R.id.button_3_2)
        val b33 = findViewById<ImageButton>(R.id.button_3_3)
        val buttonList: List<ImageButton> = listOf(b11,b12,b13,b21,b22,b23,b31,b32,b33)
        val clearBoardButton = findViewById<Button>(R.id.clear_board_button)
        val winnerText = findViewById<TextView>(R.id.winner_text)
        val playAgainText = findViewById<TextView>(R.id.play_again_text)
        val noImage = R.drawable.default_button_image
        val xImage = R.drawable.x
        val oImage = R.drawable.o
        var firstPlayer = true


        fun clearBoard() {
            for(b in buttonList){
                b.setImageResource(noImage)
                b.contentDescription = "unclicked"
            }
            if(winnerText.visibility==View.VISIBLE){
                winnerText.visibility=View.GONE
                playAgainText.visibility=View.GONE
            }
        }

        fun isEmpty(b:ImageButton):Boolean {
            if (b.contentDescription == "unclicked") return true
            return false
        }


        fun setLetter(b: ImageButton){
            if(isEmpty(b)) {
                if (firstPlayer) b.setImageResource(xImage)
                else b.setImageResource(oImage)
                firstPlayer = !firstPlayer
                b.contentDescription = "clicked"
            }
        }

        fun displayWinner(winner: String){
            if(winner=="x"){
                winnerText.text = "X WINS"
            }
            else winnerText.text = "O WINS"
            winnerText.visibility= View.VISIBLE
            playAgainText.visibility=View.VISIBLE
        }

        fun checkForWinner(){
            val winner = ""

            if(winner != ""){
                displayWinner(winner)
            }
        }


        b11.setOnClickListener {
            setLetter(b11)
            checkForWinner()
        }
        b12.setOnClickListener {
            setLetter(b12)
            checkForWinner()
        }
        b13.setOnClickListener {
            setLetter(b13)
            checkForWinner()
        }
        b21.setOnClickListener {
            setLetter(b21)
            checkForWinner()
        }
        b22.setOnClickListener{
            setLetter(b22)
            checkForWinner()
        }
        b23.setOnClickListener{
            setLetter(b23)
            checkForWinner()
        }
        b31.setOnClickListener{
            setLetter(b31)
            checkForWinner()
        }
        b32.setOnClickListener{
            setLetter(b32)
            checkForWinner()
        }
        b33.setOnClickListener{
            setLetter(b33)
            checkForWinner()
        }
        clearBoardButton.setOnClickListener{
            clearBoard()
        }
    }
}