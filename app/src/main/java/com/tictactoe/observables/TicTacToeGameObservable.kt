package com.tictactoe.observables

import android.databinding.BindingAdapter
import android.databinding.InverseMethod
import android.databinding.ObservableField
import android.view.View
import android.widget.Toast
import com.tictactoe.R
import com.tictactoe.Util.AppContext
import com.tictactoe.viewmodel.TicTacToeViewModel

class TicTacToeGameObservable(var viewModel: TicTacToeViewModel) {


    fun onClickAction(view: View) {

        if (!checkIsBoardFull()) {
            when (view.id) {

                R.id.firstRowFirstCol -> {
                    viewModel.fistRowFistColumn.set(viewModel.currentPlayer.get())
                    viewModel.fistRowFistColumn.notifyChange()
                }
                R.id.firstRowSecondCol -> {
                    viewModel.fistRowSecondColumn.set(viewModel.currentPlayer.get())
                    viewModel.fistRowSecondColumn.notifyChange()
                }
                R.id.firstRowThirdCol -> {
                    viewModel.fistRowThirdColumn.set(viewModel.currentPlayer.get())
                    viewModel.fistRowThirdColumn.notifyChange()
                }
                R.id.secondRowFirstCol -> {
                    viewModel.secondRowFirstColumn.set(viewModel.currentPlayer.get())
                    viewModel.secondRowFirstColumn.notifyChange()
                }
                R.id.secondRowSecondCol -> {
                    viewModel.secondRowSecondColumn.set(viewModel.currentPlayer.get())
                    viewModel.secondRowSecondColumn.notifyChange()
                }
                R.id.secondRowThirdCol -> {
                    viewModel.secondRowThirdColumn.set(viewModel.currentPlayer.get())
                    viewModel.secondRowThirdColumn.notifyChange()
                }
                R.id.thirdRowFirstCol -> {
                    viewModel.thirdRowFirstColumn.set(viewModel.currentPlayer.get())
                    viewModel.thirdRowFirstColumn.notifyChange()
                }
                R.id.thirdRowSecondCol -> {
                    viewModel.thirdRowSecondColumn.set(viewModel.currentPlayer.get())
                    viewModel.thirdRowSecondColumn.notifyChange()
                }
                R.id.thirdRowThirdCol -> {
                    viewModel.thirdRowThirdColumn.set(viewModel.currentPlayer.get())
                    viewModel.fistRowThirdColumn.notifyChange()
                }

            }
            changePlayer()
            if (checkForWin() == true) {
                Toast.makeText(AppContext.appContext, "Some one won the game", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(AppContext.appContext, "Board is Full", Toast.LENGTH_LONG).show()
        }


    }

    private fun changePlayer() {

        if (viewModel.currentPlayer.get() == 'X') {
            viewModel.currentPlayer.set('O')
            viewModel.currentPlayer.notifyChange()
        } else {
            viewModel.currentPlayer.set('X')
            viewModel.currentPlayer.notifyChange()
        }
    }

    private fun checkRowCol(c1: Char?, c2: Char?, c3: Char?): Boolean {

        return (c1 != '-' && c1 == c2 && c2 == c3)
    }

    private fun checkForWin(): Boolean = (checkForRowsWin() || checkForColWin() || checkForDiagonalWin())


    private fun checkForRowsWin(): Boolean {
        var match = false

        if (checkRowCol(viewModel.fistRowFistColumn.get()
                        , viewModel.fistRowSecondColumn.get()
                        , viewModel.fistRowThirdColumn.get()))
            match = true
        else if (checkRowCol(viewModel.secondRowFirstColumn.get()
                        , viewModel.secondRowSecondColumn.get()
                        , viewModel.secondRowThirdColumn.get()))
            match = true
        else if (checkRowCol(viewModel.thirdRowFirstColumn.get()
                        , viewModel.thirdRowSecondColumn.get()
                        , viewModel.thirdRowThirdColumn.get()))
            match = true

        return match
    }

    private fun checkForColWin(): Boolean {
        var match = false

        if (checkRowCol(viewModel.fistRowFistColumn.get()
                        , viewModel.secondRowFirstColumn.get()
                        , viewModel.thirdRowFirstColumn.get()))
            match = true
        else if (checkRowCol(viewModel.fistRowSecondColumn.get()
                        , viewModel.secondRowSecondColumn.get()
                        , viewModel.thirdRowSecondColumn.get()))
            match = true
        else if (checkRowCol(viewModel.fistRowThirdColumn.get()
                        , viewModel.secondRowThirdColumn.get()
                        , viewModel.thirdRowThirdColumn.get()))
            match = true

        return match
    }

    private fun checkForDiagonalWin(): Boolean {
        var match = false

        if (checkRowCol(viewModel.fistRowFistColumn.get()
                        , viewModel.secondRowSecondColumn.get()
                        , viewModel.thirdRowThirdColumn.get()))
            match = true
        else if (checkRowCol(viewModel.fistRowThirdColumn.get()
                        , viewModel.secondRowSecondColumn.get()
                        , viewModel.thirdRowFirstColumn.get()))
            match = true

        return match
    }

    private fun checkIsBoardFull(): Boolean {

        if (viewModel.fistRowFistColumn.get() != '-'
                && viewModel.fistRowSecondColumn.get() != '-'
                && viewModel.fistRowThirdColumn.get() != '-'
                && viewModel.secondRowFirstColumn.get() != '-'
                && viewModel.secondRowSecondColumn.get() != '-'
                && viewModel.secondRowThirdColumn.get() != '-'
                && viewModel.thirdRowFirstColumn.get() != '-'
                && viewModel.thirdRowSecondColumn.get() != '-'
                && viewModel.thirdRowThirdColumn.get() != '-')
            return true

        return false

    }


}