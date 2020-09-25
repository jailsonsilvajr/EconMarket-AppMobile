package br.com.appmobile.econmarket.views.loginandregister

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.appmobile.econmarket.R
import kotlinx.android.synthetic.main.fragment_register.view.*
import br.com.appmobile.econmarket.viewmodels.RegisterViewModel

class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)

        view.fragment_register_progressBar.visibility = View.GONE
        view.register_button.setOnClickListener(View.OnClickListener {

            view.fragment_register_progressBar.visibility = View.VISIBLE

            val email = view.fragment_register_text_input_edit_text_email.text.toString()
            val password = view.fragment_register_text_input_edit_text_password.text.toString()

            this.registerViewModel.observerUser().observe(this, Observer {

                if(it != null){

                    Toast.makeText(context, "User " + it.email, Toast.LENGTH_LONG).show()
                }else{

                    Toast.makeText(context, "Register Fail", Toast.LENGTH_LONG).show()
                }
                view.fragment_register_progressBar.visibility = View.GONE
            })
            this.registerViewModel.registerUser(email, password)
        })

        return view
    }
}