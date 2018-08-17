package com.tictactoe.dependencies.modules

import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.scopes.TicTacToeToolBarScope
import dagger.Module
import dagger.Provides

@Module
class ToolBarViewModelModule {

    @Provides
    @TicTacToeToolBarScope
    fun getPropertyChangeRegistry(): PropertyChangeRegistry = PropertyChangeRegistry()

}