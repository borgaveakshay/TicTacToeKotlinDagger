package com.aki.dependencies.modules

import android.databinding.PropertyChangeRegistry
import com.aki.dependencies.scopes.TicTacToeViewModelScope
import dagger.Module
import dagger.Provides

@Module
class TicTacToeViewModelModule {

    @Provides
    @TicTacToeViewModelScope
    fun getPropertyChangeRegistry(): PropertyChangeRegistry = PropertyChangeRegistry()

}