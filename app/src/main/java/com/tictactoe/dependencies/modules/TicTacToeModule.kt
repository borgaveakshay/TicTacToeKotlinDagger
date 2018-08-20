package com.tictactoe.dependencies.modules


import android.arch.lifecycle.ViewModelProviders
import com.tictactoe.dependencies.scopes.TicTacToeScope
import com.tictactoe.observables.PlayerDetailsDialog
import com.tictactoe.observables.TicTacToeGameObservable
import com.tictactoe.viewmodel.PlayerDetailDialogViewModel
import com.tictactoe.viewmodel.TicTacToeViewModel
import com.tictactoe.viewmodel.ToolBarViewModel
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
    fun getTicTacToeObservable(ticTacToeViewModel: TicTacToeViewModel, toolBarViewModel: ToolBarViewModel, activity: GameAcivity): TicTacToeGameObservable = TicTacToeGameObservable(ticTacToeViewModel, activity, toolBarViewModel)

    @Provides
    @TicTacToeScope
    fun getToolBarViewModel(activity: GameAcivity): ToolBarViewModel = ViewModelProviders.of(activity).get(ToolBarViewModel::class.java)

    @Provides
    @TicTacToeScope
    fun getPlayerDialogViewModel(activity: GameAcivity): PlayerDetailDialogViewModel = ViewModelProviders.of(activity).get(PlayerDetailDialogViewModel::class.java)

    @Provides
    @TicTacToeScope
    fun getPlayerDetailDialog(activity: GameAcivity, toolBarViewModel: ToolBarViewModel, playerDetailDialogViewModel: PlayerDetailDialogViewModel) = PlayerDetailsDialog(activity, toolBarViewModel, playerDetailDialogViewModel)

}