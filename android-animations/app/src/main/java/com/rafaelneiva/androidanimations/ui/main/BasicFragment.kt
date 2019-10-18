package com.rafaelneiva.androidanimations.ui.main

import android.animation.AnimatorInflater
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

        xmlViewAnimation(root)

        xmlObjAnimation(root)

        xmlObjAnimationSet(root)

        return root
    }

    private fun xmlViewAnimation(root: View) {
        val enterAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_fade_from_left)
        val exitAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_fade_to_left)
        enterAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                Handler().postDelayed({ root.tvAnimXml.startAnimation(exitAnim) }, 2000)
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })
        exitAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                root.tvAnimXml.startAnimation(enterAnim)
            }

            override fun onAnimationStart(animation: Animation?) {

            }
        })

        root.tvAnimXml.startAnimation(enterAnim)
    }

    private fun xmlObjAnimation(root: View) {
        val enterAnim = AnimatorInflater.loadAnimator(requireContext(), R.animator.scale_up)

        enterAnim.apply {
            setTarget(root.tvObjAnimXml)
            start()
        }
    }

    private fun xmlObjAnimationSet(root: View) {
        val enterAnim = AnimatorInflater.loadAnimator(requireContext(), R.animator.rotate_clockwise)

        enterAnim.apply {
            setTarget(root.tvObjSetAnimXml)
            start()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): BasicFragment {
            return BasicFragment()
        }
    }
}