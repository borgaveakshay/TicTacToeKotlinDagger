package com.tictactoe

import com.tictactoe.viewmodel.TicTacToeViewModel
import dagger.Component

@Component
interface TicTacToeComponent {

    fun getTicTacToeModel(): TicTacToeViewModel
}