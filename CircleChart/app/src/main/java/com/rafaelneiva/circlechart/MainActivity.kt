package com.rafaelneiva.circlechart

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ObjectAnimator.ofFloat(1f, 360f).apply {
            duration = 6000
            addUpdateListener { anim ->
                chartView.setProgres((anim.animatedValue as Float))
            }
            interpolator = AccelerateDecelerateInterpolator()
            repeatCount = Animation.INFINITE
            start()
        }
    }
}
