package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.android.codelabs.navigation.databinding.FlowStepOneFragmentBinding
import com.example.android.codelabs.navigation.databinding.FlowStepTwoFragmentBinding
import com.example.android.codelabs.navigation.databinding.HomeFragmentBinding

/**
 * Presents how multiple steps flow could be implemented.
 */
class FlowStepFragment : Fragment() {
    private lateinit var binding2: FlowStepTwoFragmentBinding
    private lateinit var binding1: FlowStepOneFragmentBinding
    private val safeArgs: FlowStepFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        return when (safeArgs.flowStepNumber) {
            2 -> {
                binding2 = FlowStepTwoFragmentBinding.inflate(inflater, container, false)
                binding2.root
            }
            else -> {
                binding1 = FlowStepOneFragmentBinding.inflate(inflater, container, false)
                binding1.root
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.next_button).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action)
        )
    }
}
