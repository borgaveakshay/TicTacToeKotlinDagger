package com.tictactoe.dependencies.components

import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.modules.TicTacToeViewModelModule
import com.tictactoe.dependencies.scopes.TicTacToeViewModelScope
import dagger.Component

@TicTacToeViewModelScope
@Component(modules = [TicTacToeViewModelModule::class])
interface TicTacToeViewModelComponent {

    fun getPropertyChangeRegistry(): PropertyChangeRegistry
}