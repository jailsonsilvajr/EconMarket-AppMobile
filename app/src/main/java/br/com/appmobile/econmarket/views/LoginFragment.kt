package br.com.appmobile.econmarket.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.appmobile.econmarket.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import viewmodels.LoginViewModel

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        view.fragment_login_progressBar.visibility = View.GONE
        view.register_button.setOnClickListener(View.OnClickListener {

            openFragment(RegisterFragment())
        })
        view.login_button.setOnClickListener(View.OnClickListener {

            view.fragment_login_progressBar.visibility = View.VISIBLE
            var email = fragment_login_text_input_edit_text_email.text.toString()
            var password = fragment_login_text_input_edit_text_password.text.toString()
            loginViewModel.loadUser(email, password)

            loginViewModel.getUser().observe(this, Observer {

                view.fragment_login_progressBar.visibility = View.GONE
                if(it == null){

                    Toast.makeText(context, R.string.user_not_found, Toast.LENGTH_LONG).show()
                }else{

                    Toast.makeText(context, R.string.user_found, Toast.LENGTH_LONG).show()
                }
                view.fragment_login_progressBar.visibility = View.GONE
            })
        })

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        return view
    }

    fun openFragment(fragment: Fragment){

        val fragmentTransaction = fragmentManager?.beginTransaction()?.addToBackStack(null)
        fragmentTransaction?.replace(R.id.layout_login_and_register_framelayout, fragment)?.commit()
    }
}