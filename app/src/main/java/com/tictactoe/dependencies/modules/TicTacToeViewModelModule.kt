package com.tictactoe.dependencies.modules

import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.scopes.TicTacToeViewModelScope
import dagger.Module
import dagger.Provides

@Module
class TicTacToeViewModelModule {

    @Provides
    @TicTacToeViewModelScope
    fun getPropertyChangeRegistry(): PropertyChangeRegistry = PropertyChangeRegistry()

}