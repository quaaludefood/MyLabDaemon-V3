package com.phil.mylabdaemon_v3.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.phil.mylabdaemon_v3.R
import com.phil.mylabdaemon_v3.ui.auth.state.RegistrationFields
import com.phil.mylabdaemon_v3.util.GenericApiResponse
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment :  BaseAuthFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "RegisteredFragment: ${viewModel.hashCode()}")


        subscribeObservers()

    }

    fun subscribeObservers() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer {
            it.registrationFields?.let{registrationFields ->

                registrationFields.registration_email?.let{input_email.setText(it)}
                registrationFields.registration_username?.let{input_username.setText(it)}
                registrationFields.registration_password?.let{input_password.setText(it)}
                registrationFields.registration_confirm_password?.let{input_password_confirm.setText(it)}

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.setRegistrationFields(
            RegistrationFields(
                input_email.text.toString(),
                input_username.text.toString(),
                input_password.text.toString(),
                input_password_confirm.text.toString()
            )
        )
    }
}
