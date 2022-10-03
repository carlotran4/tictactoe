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
        val lines = arrayOf(
            arrayOf(arrayOf(0,0), arrayOf(0,1), arrayOf(0,2)),
            arrayOf(arrayOf(1,0), arrayOf(1,1), arrayOf(1,2)),
            arrayOf(arrayOf(2,0), arrayOf(2,1), arrayOf(2,2)),
            arrayOf(arrayOf(0,0), arrayOf(1,0), arrayOf(2,0)),
            arrayOf(arrayOf(0,1), arrayOf(1,1), arrayOf(2,1)),
            arrayOf(arrayOf(0,2), arrayOf(1,2), arrayOf(2,2)),
            arrayOf(arrayOf(0,0), arrayOf(1,1), arrayOf(2,2)),
            arrayOf(arrayOf(2,0), arrayOf(1,1), arrayOf(0,2)),
        )
        var board = arrayOf(
            arrayOf(0,0,0),
            arrayOf(0,0,0),
            arrayOf(0,0,0)
        )

        val coord11 = arrayOf(0,0)
        val coord12 = arrayOf(0,1)
        val coord13 = arrayOf(0,2)
        val coord21 = arrayOf(1,0)
        val coord22 = arrayOf(1,1)
        val coord23 = arrayOf(1,2)
        val coord31 = arrayOf(2,0)
        val coord32 = arrayOf(2,1)
        val coord33 = arrayOf(2,2)

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
            board = arrayOf(
                arrayOf(0,0,0),
                arrayOf(0,0,0),
                arrayOf(0,0,0))
            firstPlayer=true
        }

        fun isEmpty(b:ImageButton):Boolean {
            if (b.contentDescription == "unclicked") return true
            return false
        }


        fun setLetter(b: ImageButton,coordinates:Array<Int>){
            if(isEmpty(b)) {
                if (firstPlayer) b.setImageResource(xImage)
                else b.setImageResource(oImage)
                firstPlayer = !firstPlayer
                b.contentDescription = "clicked"
                if(!firstPlayer)board[coordinates[0]][coordinates[1]]=1
                else board[coordinates[0]][coordinates[1]]=2
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

        fun checkLine(line:Array<Array<Int>>):Int{
            var player1 = 0
            var player2 = 0
            for(point in line){
                if(board[point[0]][point[1]]==1){
                    player1++
                }
                if(board[point[0]][point[1]]==2){
                    player2++
                }
            }
            if(player1==3){
                return 1
            }
            if(player2==3){
                return 2
            }
            return 0
        }

        fun checkForWinner(){
            var winner = 0
            for(line in lines){
                if(checkLine(line)==1) winner = 1
                if(checkLine(line)==2) winner = 2
            }
            if(winner==1) displayWinner("x")
            if(winner==2) displayWinner("o")

        }


        b11.setOnClickListener {
            setLetter(b11,coord11)
            checkForWinner()
        }
        b12.setOnClickListener {
            setLetter(b12,coord12)
            checkForWinner()
        }
        b13.setOnClickListener {
            setLetter(b13,coord13)
            checkForWinner()
        }
        b21.setOnClickListener {
            setLetter(b21,coord21)
            checkForWinner()
        }
        b22.setOnClickListener{
            setLetter(b22,coord22)
            checkForWinner()
        }
        b23.setOnClickListener{
            setLetter(b23,coord23)
            checkForWinner()
        }
        b31.setOnClickListener{
            setLetter(b31,coord31)
            checkForWinner()
        }
        b32.setOnClickListener{
            setLetter(b32,coord32)
            checkForWinner()
        }
        b33.setOnClickListener{
            setLetter(b33,coord33)
            checkForWinner()
        }
        clearBoardButton.setOnClickListener{
            clearBoard()
        }
    }
}