package com.aki.dependencies.components

import com.aki.dependencies.modules.TicTacToeModule
import com.aki.dependencies.scopes.TicTacToeScope
import com.aki.observables.PlayerDetailsDialog
import com.aki.observables.TicTacToeGameObservable
import com.aki.viewmodel.TicTacToeViewModel
import com.aki.viewmodel.ToolBarViewModel
import com.aki.views.GameAcivity
import dagger.Component

@TicTacToeScope
@Component(modules = arrayOf(TicTacToeModule::class))
interface TicTacToeComponent {

    fun getToolBarViewModel(): ToolBarViewModel
    fun getGameActivity(): GameAcivity
    fun getViewModel(): TicTacToeViewModel
    fun getTicTacToeObservable(): TicTacToeGameObservable
    fun getPlayerDetailDialog(): PlayerDetailsDialog
}