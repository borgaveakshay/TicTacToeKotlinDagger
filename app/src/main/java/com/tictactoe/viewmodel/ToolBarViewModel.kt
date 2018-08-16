package com.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.Observable
import android.databinding.ObservableField
import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.components.DaggerTicTacToeToolBarComponent
import com.tictactoe.dependencies.components.DaggerTicTacToeViewModelComponent
import com.tictactoe.dependencies.components.TicTacToeToolBarComponent
import com.tictactoe.dependencies.components.TicTacToeViewModelComponent
import javax.inject.Inject

data class ToolBarViewModel(var player1: ObservableField<String>
                            , var player2: ObservableField<String>
                            , var currentPlayer: ObservableField<String>) : Observable, ViewModel() {

    @Inject constructor() : this(ObservableField("Player1"),
            ObservableField("Player2"),
            ObservableField("Player1"))


    val mTicTacToeToolBarComponent: TicTacToeToolBarComponent = DaggerTicTacToeToolBarComponent
            .builder()
            .ticTacToeViewModelComponent(DaggerTicTacToeViewModelComponent.builder().build())
            .build()
    val mPropertyChangeRegistry: PropertyChangeRegistry = mTicTacToeToolBarComponent.getPropertyChangeRegistry()
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

        mPropertyChangeRegistry.remove(callback)
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

        mPropertyChangeRegistry.add(callback)
    }

    fun notifyChange() {
        mPropertyChangeRegistry.notifyCallbacks(this, 0, null)
    }
}