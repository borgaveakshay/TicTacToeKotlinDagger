package com.aki.observables

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.Toast
import com.aki.R
import com.aki.databinding.PlayerNameInputDialogBinding
import com.aki.viewmodel.PlayerDetailDialogViewModel
import com.aki.viewmodel.ToolBarViewModel
import com.aki.views.GameAcivity
import com.aki.Util.DialogHelper
import javax.inject.Inject

class PlayerDetailsDialog @Inject constructor(val activity: GameAcivity, val toolBarViewModel: ToolBarViewModel, var dialogViewModel: PlayerDetailDialogViewModel) : LifecycleObserver {

    val mPlayerNameInputDialogBinding: PlayerNameInputDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(activity), R.layout.player_name_input_dialog, null, false)
    private val alertHelper: DialogHelper = DialogHelper.Builder()
            .setContext(activity)
            .setPositiveButtonText("Add New Names")
            .setNegativeButtonText("Use Default")
            .setView(mPlayerNameInputDialogBinding.root)
            .setTitle("Player Details")
            .setHeight(1000)
            .setWidht(1000)
            .setNegitiveClickListener(DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })
            .build()
    val alert: AlertDialog? = alertHelper.getAlertDialog()
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        mPlayerNameInputDialogBinding.toolBar = toolBarViewModel
        if (!dialogViewModel.isDialogShown) {
            alert?.setCancelable(false)
            alert?.show()
            alert?.window?.setLayout(alertHelper.dialogHeight, alertHelper.dialogWidth)
            dialogViewModel.isDialogShown = true
            alert?.getButton(AlertDialog.BUTTON_POSITIVE)?.setOnClickListener {
                if (!mPlayerNameInputDialogBinding.toolBar?.player1.isNullOrEmpty() && !mPlayerNameInputDialogBinding.toolBar?.player2.isNullOrEmpty()) {
                    toolBarViewModel.currentPlayer = mPlayerNameInputDialogBinding.toolBar?.player1!!
                    toolBarViewModel.player1 = mPlayerNameInputDialogBinding.toolBar?.player1!!
                    toolBarViewModel.player2 = mPlayerNameInputDialogBinding.toolBar?.player2!!
                    toolBarViewModel.notifyChange()
                    alert.dismiss()
                } else {
                    Toast.makeText(activity, "Player names can not be empty", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

}