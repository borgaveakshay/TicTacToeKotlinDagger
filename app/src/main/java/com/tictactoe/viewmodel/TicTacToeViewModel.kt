package com.tictactoe.viewmodel

import android.arch.lifecycle.ViewModel
import android.databinding.BaseObservable
import android.databinding.Observable
import android.databinding.ObservableField
import android.databinding.PropertyChangeRegistry
import com.tictactoe.R
import kotlinx.android.synthetic.main.activity_game_acivity.view.*
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
                                          , var thirdRowThirdColumn: ObservableField<Char>) : Observable, ViewModel() {
    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    @Inject constructor() : this(ObservableField('X')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-')
            , ObservableField('-'))


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }

    fun init() {
        fistRowFistColumn.set('-')
        fistRowSecondColumn.set('-')
        fistRowThirdColumn.set('-')
        secondRowFirstColumn.set('-')
        secondRowSecondColumn.set('-')
        secondRowThirdColumn.set('-')
        thirdRowFirstColumn.set('-')
        thirdRowSecondColumn.set('-')
        thirdRowThirdColumn.set('-')
        notifyChange()
    }

    /**
     * Notifies listeners that all properties of this instance have changed.
     */
    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }
}