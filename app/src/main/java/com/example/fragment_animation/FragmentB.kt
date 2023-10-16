package com.example.fragment_animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R

class FragmentB : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn)?.setOnClickListener{
            val fragment = FragmentC()
            activity?.supportFragmentManager?.beginTransaction()
                ?.setCustomAnimations(
                    R.anim.enter_top_to_buttom, // R.anim.enter_right_to_left,
                    R.anim.exit_top_to_buttom,  // R.anim.exit_right_to_left,
                    R.anim.enter_buttom_to_top, // R.anim.enter_left_to_right,
                    R.anim.exit_bottom_to_top   // R.anim.exit_left_to_right
                )
                ?.replace(R.id.frame, fragment)
                ?.addToBackStack(null)
                ?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ?.commit()
        }
        view.findViewById<Button>(R.id.btnBack)?.setOnClickListener{
            activity?.supportFragmentManager?.popBackStack()
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentB().apply {
                arguments = Bundle().apply { }
            }
    }
}