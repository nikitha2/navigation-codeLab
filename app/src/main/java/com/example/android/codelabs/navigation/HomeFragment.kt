/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.view.*
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.android.codelabs.navigation.MainActivity.Companion.options
import com.example.android.codelabs.navigation.databinding.HomeFragmentBinding

/**
 * Fragment used to show how to navigate to another destination
 */
class HomeFragment : Fragment() {
    lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Set an OnClickListener, using Navigation.createNavigateOnClickListener()
        binding.navigateDestinationButton.setOnClickListener {
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }


        //Update the OnClickListener to navigate using an action
        /**Option 1 to do it
        binding.navigateActionButton.setOnClickListener(
          Navigation.createNavigateOnClickListener(R.id.next_action, null)
        )*/

        /**Option 2 to do it*/
        binding.navigateActionButton.setOnClickListener {
            findNavController().navigate(R.id.next_action, null, options)
        }

        /**Option 3 to goto step 2: update flowStepNumberArg and action then navigate*/
        /**binding.navigateActionButton.setOnClickListener {
            val flowStepNumberArg = 2
            val action = HomeFragmentDirections.nextAction(flowStepNumberArg)
            findNavController().navigate(action)
        }*/

        binding.navigateActivityButton.setOnClickListener{
            findNavController().navigate(R.id.next_activity, bundleOf("userId" to "someUser"), options)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }
}
