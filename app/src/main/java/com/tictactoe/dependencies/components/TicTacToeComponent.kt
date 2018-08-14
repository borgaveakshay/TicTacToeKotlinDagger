package com.tictactoe.dependencies.components

import com.tictactoe.dependencies.modules.TicTacToeModule
import com.tictactoe.viewmodel.TicTacToeViewModel
import com.tictactoe.views.GameAcivity
import dagger.Component

@Component(modules = [TicTacToeModule::class])
interface TicTacToeComponent {

    fun getGameActivity(): GameAcivity
    fun getViewModel(): TicTacToeViewModel
}