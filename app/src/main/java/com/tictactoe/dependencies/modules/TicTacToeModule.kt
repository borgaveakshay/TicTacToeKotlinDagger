package com.tictactoe.dependencies.modules


import android.arch.lifecycle.ViewModelProviders
import com.tictactoe.viewmodel.TicTacToeViewModel
import com.tictactoe.views.GameAcivity
import dagger.Module
import dagger.Provides

@Module
class TicTacToeModule(val activity: GameAcivity) {

    @Provides
    fun getGameActivity(): GameAcivity = activity

    @Provides
    fun getTicTacToeViewModel(activity: GameAcivity): TicTacToeViewModel = ViewModelProviders.of(activity).get(TicTacToeViewModel::class.java)


}