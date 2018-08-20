package com.tictactoe.views


import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Toast
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


        if (savedInstanceState == null) {
            val alertDialog: DialogHelper = DialogHelper.Builder()
                    .setContext(this)
                    .setPositiveButtonText("Add New Names")
                    .setNegativeButtonText("Use Default")
                    .setView(mPlayerNameInputDialogBinding.root)
                    .setTitle("Player Details")
                    .setHeight(1000)
                    .setWidht(1000)
                    .setPositiveClickListener(DialogInterface.OnClickListener { dialogInterface, i ->
                        if (!mPlayerNameInputDialogBinding.toolBar?.player1.isNullOrEmpty() && !mPlayerNameInputDialogBinding.toolBar?.player2.isNullOrEmpty()) {
                            mAcivityBinding.toolBar?.currentPlayer = mPlayerNameInputDialogBinding.toolBar!!.player1
                            mAcivityBinding.toolBar?.notifyChange()
                            dialogInterface.dismiss()
                        } else {
                            Toast.makeText(this@GameAcivity, "Player names can not be empty", Toast.LENGTH_LONG).show()
                            return@OnClickListener
                        }
                    })
                    .setNegitiveClickListener(DialogInterface.OnClickListener { dialogInterface, i ->
                        dialogInterface.dismiss()
                    })
                    .build()


            val alert = alertDialog.getAlertDialog()


            alert.setCancelable(false)
            alert.show()
            alert.window.setLayout(alertDialog.dialogHeight, alertDialog.dialogWidth)
        }

        mAcivityBinding.ticTacToeModel = mTicTacToeComponent.getViewModel()
        mAcivityBinding.toolBar = mPlayerNameInputDialogBinding.toolBar
        mAcivityBinding.ticTacToeObserver = mTicTacToeComponent.getTicTacToeObservable()
        mAcivityBinding.setLifecycleOwner(this)
        lifecycle.addObserver(mTicTacToeComponent.getTicTacToeObservable())
        Util.blinkAnimation(mAcivityBinding.currentPlayer, this)

    }


}
