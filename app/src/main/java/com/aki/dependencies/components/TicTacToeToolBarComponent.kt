package com.aki.dependencies.components

import android.databinding.PropertyChangeRegistry
import com.aki.dependencies.modules.ToolBarViewModelModule
import com.aki.dependencies.scopes.TicTacToeToolBarScope
import dagger.Component

@TicTacToeToolBarScope
@Component(modules = [ToolBarViewModelModule::class])
interface TicTacToeToolBarComponent {
    fun getPropertyChangeRegistry(): PropertyChangeRegistry
}