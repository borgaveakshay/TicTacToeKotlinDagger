package com.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Observable
import android.databinding.ObservableField
import javax.inject.Inject

data class TicTacToeViewModel constructor(var currentPlayer: ObservableField<Char>
                                          , var fistRowFistColumn: ObservableField<Char>
                                          , var fistRowSecondColumn: ObservableField<Char>
                                          , var fistRowThirdColumn: ObservableField<Char>
                                          , var secondRowFirstColumn: ObservableField<Char>
                                          , var secondRowSecondColumn: ObservableField<Char>
                                          , var secondRowThirdColumn: ObservableField<Char>
                                          , var thirdRowFirstColumn: ObservableField<Char>
                                          , var thirdRowSecondColumn: ObservableField<Char>
                                          , var thirdRowThirdColumn: ObservableField<Char>) :  ViewModel() {

    @Inject constructor() : this(ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-'))




}