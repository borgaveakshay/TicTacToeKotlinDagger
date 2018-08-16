package com.tictactoe.dependencies.components

import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.scopes.TicTacToeScope
import com.tictactoe.dependencies.scopes.TicTacToeToolBarScope
import com.tictactoe.dependencies.scopes.TicTacToeViewModelScope
import com.tictactoe.viewmodel.ToolBarViewModel
import dagger.Component

@TicTacToeToolBarScope
@Component(dependencies = [TicTacToeViewModelComponent::class])
interface TicTacToeToolBarComponent {

    fun getPropertyChangeRegistry(): PropertyChangeRegistry
    fun getToolBarViewModel(): ToolBarViewModel
}