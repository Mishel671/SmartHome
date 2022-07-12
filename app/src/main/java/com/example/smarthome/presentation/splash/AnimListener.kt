package com.example.smarthome.presentation.splash

import android.animation.Animator

abstract class AnimListener: Animator.AnimatorListener {

    abstract override fun onAnimationEnd(p0: Animator?);

    override fun onAnimationStart(p0: Animator?) {
    }

    override fun onAnimationCancel(p0: Animator?) {
    }

    override fun onAnimationRepeat(p0: Animator?) {
    }
}