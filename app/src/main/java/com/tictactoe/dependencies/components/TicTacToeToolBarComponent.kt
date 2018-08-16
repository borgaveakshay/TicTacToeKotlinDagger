package com.tictactoe.dependencies.components

import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.scopes.TicTacToeToolBarScope
import dagger.Component

@TicTacToeToolBarScope
@Component(dependencies = [TicTacToeViewModelComponent::class])
interface TicTacToeToolBarComponent {

    fun getPropertyChangeRegistry(): PropertyChangeRegistry
}