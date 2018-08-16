package com.tictactoe.dependencies.modules


import android.arch.lifecycle.ViewModelProviders
import com.tictactoe.dependencies.scopes.TicTacToeScope
import com.tictactoe.observables.TicTacToeGameObservable
import com.tictactoe.viewmodel.TicTacToeViewModel
import com.tictactoe.views.GameAcivity
import dagger.Module
import dagger.Provides

@Module
class TicTacToeModule(val activity: GameAcivity) {

    @Provides
    @TicTacToeScope
    fun getGameActivity(): GameAcivity = activity

    @Provides
    @TicTacToeScope
    fun getTicTacToeViewModel(activity: GameAcivity): TicTacToeViewModel = ViewModelProviders.of(activity).get(TicTacToeViewModel::class.java)

    @Provides
    @TicTacToeScope
    fun getTicTacToeObservable(ticTacToeViewModel: TicTacToeViewModel, activity: GameAcivity): TicTacToeGameObservable = TicTacToeGameObservable(ticTacToeViewModel, activity)


}