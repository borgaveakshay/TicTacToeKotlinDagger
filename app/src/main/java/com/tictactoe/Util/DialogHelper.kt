package com.tictactoe.Util

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.view.View

class DialogHelper private constructor() {

    private var layoutId: Int = 0
    lateinit var dialogView: View
    private var isPositiveButtonEnabled: Boolean = true
    private var isNegativeButtonEnabled: Boolean = true
    private var positiveButtonText: String = "OK"
    private var negativeButtonText: String = "Cancel"
    lateinit var context: Context
    lateinit var positiveButtonListener: DialogInterface.OnClickListener
    lateinit var negativeButtonListener: DialogInterface.OnClickListener

    private constructor(con: Context,
                        id: Int,
                        isPosButtonEnabled: Boolean,
                        isNegButtonEnabled: Boolean,
                        posButtonText: String,
                        negButtonText: String,
                        posOnClickListener: DialogInterface.OnClickListener,
                        negOnClickListener: DialogInterface.OnClickListener) : this() {

        context = con
        layoutId = id
        isPositiveButtonEnabled = isPosButtonEnabled
        isNegativeButtonEnabled = isNegButtonEnabled
        positiveButtonText = posButtonText
        negativeButtonText = negButtonText
        positiveButtonListener = posOnClickListener
        negativeButtonListener = negOnClickListener
    }

    private constructor(con: Context,
                        view: View,
                        isPosButtonEnabled: Boolean,
                        isNegButtonEnabled: Boolean,
                        posButtonText: String,
                        negButtonText: String,
                        posOnClickListener: DialogInterface.OnClickListener,
                        negOnClickListener: DialogInterface.OnClickListener) : this() {

        context = con
        dialogView = view
        isPositiveButtonEnabled = isPosButtonEnabled
        isNegativeButtonEnabled = isNegButtonEnabled
        positiveButtonText = posButtonText
        negativeButtonText = negButtonText
        positiveButtonListener = posOnClickListener
        negativeButtonListener = negOnClickListener
    }

    fun getAlertDialog(): AlertDialog {

        if (layoutId != 0)
            return AlertDialog.Builder(context)
                    .setView(layoutId)
                    .setPositiveButton(positiveButtonText, positiveButtonListener)
                    .setNegativeButton(negativeButtonText, negativeButtonListener)
                    .create()

        return AlertDialog.Builder(context)
                .setView(dialogView)
                .setPositiveButton(positiveButtonText, positiveButtonListener)
                .setNegativeButton(negativeButtonText, negativeButtonListener)
                .create()
    }

    class Builder {

        private var layoutId: Int = 0
        lateinit var dialogView: View
        private var isPositiveButtonEnabled: Boolean = true
        private var isNegativeButtonEnabled: Boolean = true
        private var positiveButtonText: String = "OK"
        private var negativeButtonText: String = "Cancel"
        private lateinit var context: Context
        private var posDialogInterface: DialogInterface.OnClickListener = DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() }
        private var negDialogInterface: DialogInterface.OnClickListener = DialogInterface.OnClickListener { dialogInterface, i -> dialogInterface.dismiss() }

        fun setLayoutId(id: Int) = apply {
            layoutId = id
        }

        fun isPositiveButtonEnabled(enabled: Boolean) = apply {
            isPositiveButtonEnabled = enabled
        }

        fun isNegativeButtonEnabled(enabled: Boolean) = apply {

            isNegativeButtonEnabled = enabled
        }

        fun setPositiveButtonText(buttonText: String) = apply {

            positiveButtonText = buttonText
        }

        fun setNegativeButtonText(buttonText: String) = apply {

            negativeButtonText = buttonText
        }

        fun setContext(con: Context): Builder = apply {

            context = con
        }

        fun setPositiveClickListener(posinterface: DialogInterface.OnClickListener) = apply {

            posDialogInterface = posinterface
        }

        fun setNegitiveClickListener(neginterface: DialogInterface.OnClickListener) = apply {

            negDialogInterface = neginterface
        }

        fun setView(view: View) = apply {
            dialogView = view
        }

        fun build(): DialogHelper {

            if (dialogView != null) {

                return DialogHelper(context,
                        dialogView,
                        isPositiveButtonEnabled,
                        isNegativeButtonEnabled,
                        positiveButtonText,
                        negativeButtonText,
                        posDialogInterface,
                        negDialogInterface)

            }

            return DialogHelper(context,
                    layoutId,
                    isPositiveButtonEnabled,
                    isNegativeButtonEnabled,
                    positiveButtonText,
                    negativeButtonText,
                    posDialogInterface,
                    negDialogInterface)


        }


    }


}