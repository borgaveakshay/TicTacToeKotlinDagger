package com.tictactoe.observables

import android.databinding.BindingAdapter
import android.view.View
import android.widget.Toast
import com.tictactoe.R
import com.tictactoe.Util.AppContext
import com.tictactoe.viewmodel.TicTacToeViewModel

class TicTacToeGameObservable(var viewModel: TicTacToeViewModel) {


    fun onClickAction(view: View) {

        if (!checkIsBoardFull()) {
            when (view.id) {

                R.id.firstRowFirstCol -> viewModel.fistRowFistColumn = viewModel.currentPlayer
                R.id.firstRowSecondCol -> viewModel.fistRowSecondColumn = viewModel.currentPlayer
                R.id.firstRowThirdCol -> viewModel.fistRowThirdColumn = viewModel.currentPlayer
                R.id.secondRowFirstCol -> viewModel.secondRowFirstColumn = viewModel.currentPlayer
                R.id.secondRowSecondCol -> viewModel.secondRowSecondColumn = viewModel.currentPlayer
                R.id.secondRowThirdCol -> viewModel.secondRowThirdColumn = viewModel.currentPlayer
                R.id.thirdRowFirstCol -> viewModel.thirdRowFirstColumn = viewModel.currentPlayer
                R.id.thirdRowSecondCol -> viewModel.thirdRowSecondColumn = viewModel.currentPlayer
                R.id.thirdRowThirdCol -> viewModel.thirdRowThirdColumn = viewModel.currentPlayer

            }
            changePlayer()
            if (checkForWin() == true) {
                Toast.makeText(AppContext.appContext, "Some one won the game", Toast.LENGTH_LONG).show()
            }
        } else
            Toast.makeText(AppContext.appContext, "Board is Full", Toast.LENGTH_LONG).show()


    }

    private fun changePlayer() {

        if (viewModel.currentPlayer == 'X')
            viewModel.currentPlayer = 'O'
        else
            viewModel.currentPlayer = 'X'
    }

    private fun checkRowCol(c1: Char, c2: Char, c3: Char): Boolean {

        return (c1 != '-' && c1 == c2 && c2 == c3)
    }

    private fun checkForWin(): Boolean = (checkForRowsWin() || checkForColWin() || checkForDiagonalWin())


    private fun checkForRowsWin(): Boolean {
        var match = false

        if (checkRowCol(viewModel.fistRowFistColumn
                        , viewModel.fistRowSecondColumn
                        , viewModel.fistRowThirdColumn))
            match = true
        else if (checkRowCol(viewModel.secondRowFirstColumn
                        , viewModel.secondRowSecondColumn
                        , viewModel.secondRowThirdColumn))
            match = true
        else if (checkRowCol(viewModel.thirdRowFirstColumn
                        , viewModel.thirdRowSecondColumn
                        , viewModel.thirdRowThirdColumn))
            match = true

        return match
    }

    private fun checkForColWin(): Boolean {
        var match = false

        if (checkRowCol(viewModel.fistRowFistColumn
                        , viewModel.secondRowFirstColumn
                        , viewModel.thirdRowFirstColumn))
            match = true
        else if (checkRowCol(viewModel.fistRowSecondColumn
                        , viewModel.secondRowSecondColumn
                        , viewModel.thirdRowSecondColumn))
            match = true
        else if (checkRowCol(viewModel.fistRowThirdColumn
                        , viewModel.secondRowThirdColumn
                        , viewModel.thirdRowThirdColumn))
            match = true

        return match
    }

    private fun checkForDiagonalWin(): Boolean {
        var match = false

        if (checkRowCol(viewModel.fistRowFistColumn
                        , viewModel.secondRowSecondColumn
                        , viewModel.thirdRowThirdColumn))
            match = true
        else if (checkRowCol(viewModel.fistRowThirdColumn
                        , viewModel.secondRowSecondColumn
                        , viewModel.thirdRowFirstColumn))
            match = true

        return match
    }

    private fun checkIsBoardFull(): Boolean {

        if (viewModel.fistRowFistColumn != '-'
                && viewModel.fistRowSecondColumn != '-'
                && viewModel.fistRowThirdColumn != '-'
                && viewModel.secondRowFirstColumn != '-'
                && viewModel.secondRowSecondColumn != '-'
                && viewModel.secondRowThirdColumn != '-'
                && viewModel.thirdRowFirstColumn != '-'
                && viewModel.thirdRowSecondColumn != '-'
                && viewModel.thirdRowThirdColumn != '-')
            return true

        return false

    }


}