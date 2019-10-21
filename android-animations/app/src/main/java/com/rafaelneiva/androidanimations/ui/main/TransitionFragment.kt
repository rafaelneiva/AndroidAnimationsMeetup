package com.rafaelneiva.androidanimations.ui.main

import android.content.Intent
import android.os.Bundle
import android.transition.Fade
import android.transition.TransitionSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.Fragment
import com.rafaelneiva.androidanimations.R
import kotlinx.android.synthetic.main.fragment_transition.view.*
import androidx.core.util.Pair as APair

class TransitionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_transition, container, false)

        root.clGuitar.setOnClickListener {
            val bundle = Bundle()
            bundle.putString(DetailsActivity.titleKey, root.tvGuitar.text.toString())
            val i = Intent(requireContext(), DetailsActivity::class.java)
            i.putExtras(bundle)

            val set = TransitionSet()
            set.addTransition(Fade())

            requireActivity().window.exitTransition = set

            val p1 = APair.create<View, String>(root.ivGuitar, getString(R.string.trans_name_guitar_picture))
            val p2 = APair.create<View, String>(root.tvGuitar, getString(R.string.trans_name_guitar_title))
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), p1, p2)

            startActivity(i, options.toBundle())
        }

        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(): TransitionFragment {
            return TransitionFragment()
        }
    }
}