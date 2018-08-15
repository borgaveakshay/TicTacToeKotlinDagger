package com.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel
import javax.inject.Inject

data class TicTacToeViewModel constructor(var currentPlayer: Char
                                          , var fistRowFistColumn: Char
                                          , var fistRowSecondColumn: Char
                                          , var fistRowThirdColumn: Char
                                          , var secondRowFirstColumn: Char
                                          , var secondRowSecondColumn: Char
                                          , var secondRowThirdColumn: Char
                                          , var thirdRowFirstColumn: Char
                                          , var thirdRowSecondColumn: Char
                                          , var thirdRowThirdColumn: Char) : ViewModel() {
    @Inject constructor() : this('X'
            , '-'
            , '-'
            , '-'
            , '-'
            , '-'
            , '-'
            , '-'
            , '-'
            , '-')


}