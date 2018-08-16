package com.tictactoe.views


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tictactoe.R
import com.tictactoe.databinding.ActivityGameAcivityBinding
import com.tictactoe.databinding.ToolbarLayoutBinding
import com.tictactoe.dependencies.components.DaggerTicTacToeComponent
import com.tictactoe.dependencies.components.DaggerTicTacToeToolBarComponent
import com.tictactoe.dependencies.components.DaggerTicTacToeViewModelComponent
import com.tictactoe.dependencies.components.TicTacToeComponent
import com.tictactoe.dependencies.modules.TicTacToeModule

class GameAcivity : AppCompatActivity() {

    lateinit var mAcivityBinding: ActivityGameAcivityBinding
    lateinit var mToolbarLayoutBinding: ToolbarLayoutBinding
    lateinit var mTicTacToeComponent: TicTacToeComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTicTacToeComponent = DaggerTicTacToeComponent
                .builder()
                .ticTacToeToolBarComponent(DaggerTicTacToeToolBarComponent
                        .builder()
                        .ticTacToeViewModelComponent(DaggerTicTacToeViewModelComponent.builder().build())
                        .build())
                .ticTacToeModule(TicTacToeModule(this))
                .build()

        mAcivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_acivity)

        mAcivityBinding.ticTacToeModel = mTicTacToeComponent.getViewModel()
        mAcivityBinding.toolBar = mTicTacToeComponent.getToolBarViewModel()
        mAcivityBinding.ticTacToeObserver = mTicTacToeComponent.getTicTacToeObservable()

    }
}
