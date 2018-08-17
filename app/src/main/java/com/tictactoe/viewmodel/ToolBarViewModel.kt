package com.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.Bindable
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import com.tictactoe.dependencies.components.DaggerTicTacToeToolBarComponent
import com.tictactoe.dependencies.components.TicTacToeToolBarComponent
import javax.inject.Inject

data class ToolBarViewModel(@Bindable var player1: String
                            , @Bindable var player2: String
                            , @Bindable var currentPlayer: String) : Observable, ViewModel() {

    @Inject constructor() : this("Player1",
            "Player2",
            "Player1")


    val mTicTacToeToolBarComponent: TicTacToeToolBarComponent = DaggerTicTacToeToolBarComponent.builder().build()

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