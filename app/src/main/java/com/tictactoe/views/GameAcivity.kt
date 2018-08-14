package com.tictactoe.views


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.tictactoe.R
import com.tictactoe.databinding.ActivityGameAcivityBinding
import com.tictactoe.viewmodel.TicTacToeViewModel
import javax.inject.Inject

class GameAcivity : AppCompatActivity() {

    lateinit var mAcivityBinding: ActivityGameAcivityBinding
    @Inject lateinit var mViewModel: TicTacToeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAcivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_acivity)





    }
}
