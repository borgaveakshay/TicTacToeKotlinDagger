package com.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel
import javax.inject.Inject

data class PlayerDetailDialogViewModel(var isDialogShown: Boolean) : ViewModel() {

    @Inject constructor() : this(false)
}