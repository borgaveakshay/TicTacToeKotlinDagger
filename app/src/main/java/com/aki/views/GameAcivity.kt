package com.aki.views


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.aki.R
import com.aki.databinding.ActivityGameAcivityBinding
import com.aki.dependencies.components.DaggerTicTacToeComponent
import com.aki.dependencies.components.TicTacToeComponent
import com.aki.dependencies.modules.TicTacToeModule
import com.aki.util.Util

class GameAcivity :  AppCompatActivity() {

    lateinit var mAcivityBinding: ActivityGameAcivityBinding
    lateinit var mTicTacToeComponent: TicTacToeComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTicTacToeComponent = DaggerTicTacToeComponent
                .builder()
                .ticTacToeModule(TicTacToeModule(this))
                .build()
        mAcivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_acivity)
        lifecycle.addObserver(mTicTacToeComponent.getTicTacToeObservable())
        lifecycle.addObserver(mTicTacToeComponent.getPlayerDetailDialog())

        mAcivityBinding.ticTacToeModel = mTicTacToeComponent.getViewModel()
        mAcivityBinding.toolBar = mTicTacToeComponent.getToolBarViewModel()
        mAcivityBinding.ticTacToeObserver = mTicTacToeComponent.getTicTacToeObservable()
        mAcivityBinding.setLifecycleOwner(this)

        Util.blinkAnimation(mAcivityBinding.currentPlayer, this)


    }


}
