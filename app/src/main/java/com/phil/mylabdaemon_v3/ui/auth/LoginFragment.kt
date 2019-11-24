package com.phil.mylabdaemon_v3.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.phil.mylabdaemon_v3.R
import com.phil.mylabdaemon_v3.ui.auth.state.LoginFields
import com.phil.mylabdaemon_v3.util.GenericApiResponse
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseAuthFragment()  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "LoginFragment: ${viewModel.hashCode()}")


        subscribeObservers()
    }

    fun subscribeObservers() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer {
            it.loginFields?.let{loginFields ->

                loginFields.login_email?.let{input_email.setText(it)}
                loginFields.login_password?.let{input_password.setText(it)}

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.setLoginFields(
            LoginFields(
                input_email.text.toString(),
                input_password.text.toString()
            )
        )
    }
}
