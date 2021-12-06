package com.example.lab3_5

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController


class Fragment1 : BasedFragment(R.layout.fragment1)
class Fragment2 : BasedFragment(R.layout.fragment2)
class Fragment3 : BasedFragment(R.layout.fragment3)

abstract class BasedFragment(private val res: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(res, container, false)

        layout.findViewById<View>(R.id.firstButton)?.setOnClickListener {
            findNavController().navigate(R.id.action_to1)
        }

        layout.findViewById<View>(R.id.secondButton)?.setOnClickListener {
            findNavController().navigate(R.id.action_to2)
        }

        layout.findViewById<View>(R.id.thirdButton)?.setOnClickListener {
            findNavController().navigate(R.id.action_to3)
        }

        return layout
    }

}