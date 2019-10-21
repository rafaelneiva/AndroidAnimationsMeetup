package com.rafaelneiva.androidanimations.ui.main

import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.Drawable
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

        animatedVectorDrawableDots(root)

        root.ivSearch.setOnClickListener {
            (root.ivSearch.drawable as AnimatedVectorDrawable).start()
        }

        val animals: AnimatedVectorDrawable = (root.ivAnimals.drawable as AnimatedVectorDrawable)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            animals.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                    override fun onAnimationEnd(drawable: Drawable) {
                        super.onAnimationEnd(drawable)
                        animals.start()
                    }
                })
        }
        animals.start()

        return root
    }

    private fun animatedVectorDrawableDots(root: View) {
        val dots: AnimatedVectorDrawable = (root.ivAnimVecDrawable.drawable as AnimatedVectorDrawable)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            dots.registerAnimationCallback(object : Animatable2.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable) {
                    super.onAnimationEnd(drawable)
                    dots.start()
                }
            })
        }
        dots.start()
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