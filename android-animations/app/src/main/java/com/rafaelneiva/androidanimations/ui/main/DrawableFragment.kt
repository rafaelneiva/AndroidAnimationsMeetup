package com.rafaelneiva.androidanimations.ui.main

import android.graphics.drawable.AnimationDrawable
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

        root.ivAnimationDrawable.setBackgroundResource(R.drawable.animation_running);
        val frameAnimation: AnimationDrawable = root.ivAnimationDrawable.background as AnimationDrawable;
        frameAnimation.start();

        return root
    }

    companion object {
        fun newInstance(): DrawableFragment {
            return DrawableFragment()
        }
    }
}