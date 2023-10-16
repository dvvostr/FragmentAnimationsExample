package com.example.fragment_animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN
import com.example.myapplication.R

class FragmentA : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn)?.setOnClickListener{
            val fragment = FragmentB()
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(
                    R.anim.enter_top_to_buttom,
                    R.anim.exit_top_to_buttom,
                    R.anim.enter_buttom_to_top,
                    R.anim.exit_bottom_to_top
                )
                ?.replace(R.id.frame, fragment)
                ?.addToBackStack(null)
                ?.setTransition(TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentA().apply {
                arguments = Bundle().apply {
                }
            }
    }
}