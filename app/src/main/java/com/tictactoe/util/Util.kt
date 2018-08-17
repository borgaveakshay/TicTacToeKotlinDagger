package com.tictactoe.util

import android.animation.Animator
import android.animation.AnimatorInflater
import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.tictactoe.R

class Util {

    companion object {

        fun annimate(view: View, context: Context) {
            val animatorSet: Animator? = AnimatorInflater.loadAnimator(context, R.animator.card_flip_left_in)
            animatorSet?.setTarget(view)
            animatorSet?.start()
        }

        fun blinkAnimation(view: View, context: Context){
            view.startAnimation(AnimationUtils.loadAnimation(context,R.anim.blink))
        }
    }
}