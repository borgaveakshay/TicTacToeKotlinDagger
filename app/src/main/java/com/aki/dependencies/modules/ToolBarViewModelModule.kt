package com.aki.dependencies.modules

import android.databinding.PropertyChangeRegistry
import com.aki.dependencies.scopes.TicTacToeToolBarScope
import dagger.Module
import dagger.Provides

@Module
class ToolBarViewModelModule {

    @Provides
    @TicTacToeToolBarScope
    fun getPropertyChangeRegistry(): PropertyChangeRegistry = PropertyChangeRegistry()

}