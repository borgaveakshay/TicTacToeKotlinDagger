package com.tictactoe.dependencies.components

import com.tictactoe.dependencies.modules.TicTacToeModule
import com.tictactoe.dependencies.scopes.TicTacToeScope
import com.tictactoe.observables.TicTacToeGameObservable
import com.tictactoe.viewmodel.TicTacToeViewModel
import com.tictactoe.viewmodel.ToolBarViewModel
import com.tictactoe.views.GameAcivity
import dagger.Component

@TicTacToeScope
@Component(modules = arrayOf(TicTacToeModule::class))
interface TicTacToeComponent {

    fun getToolBarViewModel():ToolBarViewModel
    fun getGameActivity(): GameAcivity
    fun getViewModel(): TicTacToeViewModel
    fun getTicTacToeObservable(): TicTacToeGameObservable
}