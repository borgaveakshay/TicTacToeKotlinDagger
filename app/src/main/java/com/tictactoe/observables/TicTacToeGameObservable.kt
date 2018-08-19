package com.tictactoe.observables

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.view.View
import com.tictactoe.R
import com.tictactoe.Util.DialogHelper
import com.tictactoe.util.Util
import com.tictactoe.viewmodel.TicTacToeViewModel
import com.tictactoe.viewmodel.ToolBarViewModel
import com.tictactoe.views.GameAcivity

class TicTacToeGameObservable(val viewModel: TicTacToeViewModel
                              , val activity: GameAcivity
                              , val toolBarViewModel: ToolBarViewModel) : LifecycleObserver {


    lateinit var alertDialog: AlertDialog
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        checkForWinAndReset()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {

        if (alertDialog.isShowing) {

            alertDialog.dismiss()
        }
    }


    fun onClickAction(view: View) {

        if (!checkIsBoardFull()) {
            when (view.id) {

                R.id.firstRowFirstCol -> {
                    if (isPositionAvailable(viewModel.fistRowFistColumn.get())) {
                        viewModel.fistRowFistColumn.set(viewModel.currentPlayer.get())
                        flipAnimation(view)
                        changePlayer()
                    }

                }
                R.id.firstRowSecondCol -> {
                    if (isPositionAvailable(viewModel.fistRowSecondColumn.get())) {
                        viewModel.fistRowSecondColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }
                }
                R.id.firstRowThirdCol -> {

                    if (isPositionAvailable(viewModel.fistRowThirdColumn.get())) {
                        viewModel.fistRowThirdColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }

                }
                R.id.secondRowFirstCol -> {
                    if (isPositionAvailable(viewModel.secondRowFirstColumn.get())) {
                        viewModel.secondRowFirstColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }

                }
                R.id.secondRowSecondCol -> {
                    if (isPositionAvailable(viewModel.secondRowSecondColumn.get())) {
                        viewModel.secondRowSecondColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }

                }
                R.id.secondRowThirdCol -> {
                    if (isPositionAvailable(viewModel.secondRowThirdColumn.get())) {
                        viewModel.secondRowThirdColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }

                }
                R.id.thirdRowFirstCol -> {

                    if (isPositionAvailable(viewModel.thirdRowFirstColumn.get())) {
                        viewModel.thirdRowFirstColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }

                }
                R.id.thirdRowSecondCol -> {
                    if (isPositionAvailable(viewModel.thirdRowSecondColumn.get())) {
                        viewModel.thirdRowSecondColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }

                }
                R.id.thirdRowThirdCol -> {
                    if (isPositionAvailable(viewModel.thirdRowThirdColumn.get())) {
                        viewModel.thirdRowThirdColumn.set(viewModel.currentPlayer.get())
                        changePlayer()
                        flipAnimation(view)
                    }

                }

            }

            checkForWinAndReset()
            viewModel.notifyChange()

        } else {
            resetGame()
        }


    }


    private fun checkForWinAndReset() {
        if (checkForWin()) {
            resetGame()

        }
    }

    fun flipAnimation(view: View) {
        Util.annimate(view, activity)
    }

    private fun isPositionAvailable(char: Char?): Boolean = char == '-'


    private fun resetGame() {


        alertDialog = DialogHelper.Builder()
                .setContext(activity)
                .setTitle("Game End")
                .setHeight(600)
                .setWidht(600)
                .setPositiveButtonText("Start New Game")
                .setPositiveClickListener(DialogInterface.OnClickListener { dialogInterface, i ->
                    viewModel.init()
                    toolBarViewModel.init()
                })
                .build().getAlertDialog()
        alertDialog.setCancelable(false)
        if (checkIsBoardFull()) {
            alertDialog.setMessage("Match Drawn!")
        } else {
            alertDialog.setMessage("${toolBarViewModel.currentPlayer} won the game. Congratulations")
        }

        alertDialog.show()


    }

    private fun changePlayer() {

        viewModel.currentPlayer.set(when (viewModel.currentPlayer.get()) {
            'X' -> 'O'
            'O' -> 'X'
            else -> 'X'
        })

        toolBarViewModel.currentPlayer = (when (toolBarViewModel.currentPlayer) {
            toolBarViewModel.player1 -> toolBarViewModel.player2
            toolBarViewModel.player2 -> toolBarViewModel.player1
            else -> toolBarViewModel.player1
        })
        toolBarViewModel.notifyChange()
        viewModel.notifyChange()

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