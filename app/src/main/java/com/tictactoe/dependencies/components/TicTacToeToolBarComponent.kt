package com.tictactoe.dependencies.components

import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.modules.ToolBarViewModelModule
import com.tictactoe.dependencies.scopes.TicTacToeToolBarScope
import dagger.Component

@TicTacToeToolBarScope
@Component(modules = [ToolBarViewModelModule::class])
interface TicTacToeToolBarComponent {
    fun getPropertyChangeRegistry(): PropertyChangeRegistry
}