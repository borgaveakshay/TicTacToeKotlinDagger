package com.aki.dependencies.components

import android.databinding.PropertyChangeRegistry
import com.aki.dependencies.modules.TicTacToeViewModelModule
import com.aki.dependencies.scopes.TicTacToeViewModelScope
import dagger.Component

@TicTacToeViewModelScope
@Component(modules = [TicTacToeViewModelModule::class])
interface TicTacToeViewModelComponent {

    fun getPropertyChangeRegistry(): PropertyChangeRegistry
}