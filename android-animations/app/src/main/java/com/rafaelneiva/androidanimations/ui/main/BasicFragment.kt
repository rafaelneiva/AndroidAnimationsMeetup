package com.rafaelneiva.androidanimations.ui.main

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.rafaelneiva.androidanimations.R
import kotlinx.android.synthetic.main.fragment_basic.view.*

class BasicFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_basic, container, false)

        xmlAnimation(root)

        return root
    }

    private fun xmlAnimation(root: View) {
        val xmlEnterAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_fade_from_left)
        val xmlExitAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_fade_to_left)
        xmlEnterAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                Handler().postDelayed({ root.tvAnimXml.startAnimation(xmlExitAnim) }, 2000)
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        xmlExitAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                root.tvAnimXml.startAnimation(xmlEnterAnim)
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })

        root.tvAnimXml.startAnimation(xmlEnterAnim)
    }

    companion object {
        @JvmStatic
        fun newInstance(): BasicFragment {
            return BasicFragment()
        }
    }
}