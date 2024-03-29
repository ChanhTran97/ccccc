package com.example.mainactivity.login

import android.os.Bundle
import android.view.View
import com.example.mainactivity.BaseFragment
import com.example.mainactivity.R
import kotlinx.android.synthetic.main.activity_forget_password_fragment.*

class ForgetPasswordFragment : BaseFragment() {
    interface Listener {
        fun openLoginScreen()
    }

    lateinit var mListener: Listener

    override fun getTagName(): String {
        return ForgetPasswordFragment::class.java.simpleName
    }

    override fun inflateView(): Int {
        return R.layout.activity_forget_password_fragment
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvLogin.setOnClickListener {
            mListener.openLoginScreen()
        }
    }

    fun setListener(listener: Listener) {
        mListener = listener
    }

}
