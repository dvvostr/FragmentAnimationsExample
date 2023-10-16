package com.example.fragment_animation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R

class FragmentC : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_c, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btnBack)?.setOnClickListener{
            activity?.supportFragmentManager?.popBackStack()
        }
        view.findViewById<Button>(R.id.btnBackHome)?.setOnClickListener{
            activity?.supportFragmentManager?.popBackStack("FragmentA", 0)
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentC().apply {
                arguments = Bundle().apply {}
            }
    }
}