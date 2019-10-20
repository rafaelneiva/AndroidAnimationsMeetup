package com.rafaelneiva.androidanimations.ui.main

import android.graphics.drawable.*
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rafaelneiva.androidanimations.R
import kotlinx.android.synthetic.main.fragment_drawable.view.*

class DrawableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_drawable, container, false)

        animationDrawable(root)

        val dots: AnimatedVectorDrawable  = (root.ivAnimVecDrawable.drawable as AnimatedVectorDrawable)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            dots.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable) {
                    super.onAnimationEnd(drawable)
                    dots.start()
                }
            })
        }
        dots.start()

        return root
    }

    private fun animationDrawable(root: View) {
        root.ivAnimationDrawable.setBackgroundResource(R.drawable.animation_running);
        val frameAnimation: AnimationDrawable = root.ivAnimationDrawable.background as AnimationDrawable;
        frameAnimation.start();
    }

    companion object {
        fun newInstance(): DrawableFragment {
            return DrawableFragment()
        }
    }
}