package com.rafaelneiva.circletodropanimation

import android.animation.Animator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import androidx.core.animation.doOnEnd
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        triangle.setImageDrawable(CustomDrawable(Color.MAGENTA))

        ObjectAnimator.ofFloat(1f, 360f).apply {
            duration = 10000
            addUpdateListener { anim ->
                clock.setAngle((anim.animatedValue as Float).toDouble())
            }
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = Animation.INFINITE
            start()
        }
    }
}
