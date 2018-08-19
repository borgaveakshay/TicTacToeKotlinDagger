package com.tictactoe.views


import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import com.tictactoe.R
import com.tictactoe.Util.DialogHelper
import com.tictactoe.databinding.ActivityGameAcivityBinding
import com.tictactoe.databinding.PlayerNameInputDialogBinding
import com.tictactoe.dependencies.components.DaggerTicTacToeComponent
import com.tictactoe.dependencies.components.TicTacToeComponent
import com.tictactoe.dependencies.modules.TicTacToeModule
import com.tictactoe.util.Util

class GameAcivity : AppCompatActivity() {

    lateinit var mAcivityBinding: ActivityGameAcivityBinding
    lateinit var mTicTacToeComponent: TicTacToeComponent
    lateinit var mPlayerNameInputDialogBinding: PlayerNameInputDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mTicTacToeComponent = DaggerTicTacToeComponent
                .builder()
                .ticTacToeModule(TicTacToeModule(this))
                .build()

        mAcivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_acivity)

        mPlayerNameInputDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.player_name_input_dialog, null, false)

        mPlayerNameInputDialogBinding.toolBar = mTicTacToeComponent.getToolBarViewModel()


        var alertDialog: DialogHelper = DialogHelper.Builder()
                .setContext(this)
                .setPositiveButtonText("Add New Names")
                .setNegativeButtonText("Use Default")
                .setView(mPlayerNameInputDialogBinding.root)
                .setPositiveClickListener(DialogInterface.OnClickListener { dialogInterface, i ->
                    mAcivityBinding.toolBar?.currentPlayer = mPlayerNameInputDialogBinding.toolBar!!.player1
                    mAcivityBinding.toolBar?.notifyChange()
                    dialogInterface.dismiss()
                })
                .build()


        alertDialog.getAlertDialog().show()
        mAcivityBinding.ticTacToeModel = mTicTacToeComponent.getViewModel()
        mAcivityBinding.toolBar = mPlayerNameInputDialogBinding.toolBar
        mAcivityBinding.ticTacToeObserver = mTicTacToeComponent.getTicTacToeObservable()
        Util.blinkAnimation(mAcivityBinding.currentPlayer, this)

    }
}
